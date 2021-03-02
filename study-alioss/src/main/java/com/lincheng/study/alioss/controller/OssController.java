package com.lincheng.study.alioss.controller;

import com.lincheng.study.alioss.Enum.FileTypeEnum;
import com.lincheng.study.alioss.entity.OssFileInformation;
import com.lincheng.study.alioss.repository.OssFileInformationRepository;
import com.lincheng.study.alioss.service.OssFileInformationService;
import com.lincheng.study.common.domain.alioss.vo.OssFileInformationVO;
import com.lincheng.study.common.utils.R;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

@RestController
public class OssController {

    @Resource
    private OssFileInformationService ossFileInformationService;

    @Resource
    private OssFileInformationRepository ossFileInformationRepository;


    @RequestMapping("oss/upload")
    public R ossUpload(@RequestParam("file") MultipartFile file) throws Exception {

        // 校验图片格式
        FileTypeEnum fileTypeEnum = Arrays.stream(FileTypeEnum.values())
                .filter(typeEnum ->StringUtils.endsWithIgnoreCase(file.getOriginalFilename(),typeEnum.getName()))
                .findFirst()
                .orElse(null);

        if (!Optional.ofNullable(fileTypeEnum).isPresent()){
            return R.error("error");
        }

        OssFileInformationVO ossFileInformationVO = ossFileInformationService.upload(file, fileTypeEnum.getKey());


        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("status","");
        hashMap.put("response","success");
        hashMap.put("ossFileInformationVO",ossFileInformationVO);
        return R.ok().put("data",hashMap);

    }

    @RequestMapping("oss/download")
    public void ossDownload(@RequestParam("ossFileName") String ossFileName, HttpServletResponse response) throws IOException {


        OssFileInformation firstByOssFileName = ossFileInformationRepository.findFirstByOssFileName(ossFileName);
        String fileName = firstByOssFileName.getFileName();

        response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1"));

        BufferedInputStream bufferedInputStream = ossFileInformationService.download(ossFileName);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(response.getOutputStream());
        byte[] buffer = new byte[1024];
        int lenght = 0;
        while ((lenght = bufferedInputStream.read(buffer)) != -1) {
            bufferedOutputStream.write(buffer, 0, lenght);
        }
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        }
        if (bufferedInputStream != null) {
            bufferedInputStream.close();
        }

    }

    @RequestMapping("oss/delete")
    @ResponseBody
    public R ossDelete(@RequestParam("fileName") String fileName) throws Exception {

        //删除文件
        ossFileInformationService.delete(fileName);

        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("status","removed");
        hashMap.put("response","success");
        hashMap.put("name",fileName);
        return R.ok().put("data",hashMap);
    }



}
