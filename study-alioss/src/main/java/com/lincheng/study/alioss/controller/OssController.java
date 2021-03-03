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

        //校验文件格式
        FileTypeEnum fileTypeEnum = Arrays.stream(FileTypeEnum.values())
                .filter(typeEnum ->StringUtils.endsWithIgnoreCase(file.getOriginalFilename(),typeEnum.getName()))
                .findFirst()
                .orElse(null);

        if (!Optional.ofNullable(fileTypeEnum).isPresent()){
            return R.error("error");
        }

        OssFileInformationVO ossFileInformationVO = ossFileInformationService.upload(file, fileTypeEnum.getKey());


        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("status","1");
        hashMap.put("response","success");
        hashMap.put("ossFileInformationVO",ossFileInformationVO);
        return R.ok().put("data",hashMap);

    }

    @RequestMapping("oss/download")
    public R ossDownload(@RequestParam("ossFileName") String ossFileName, HttpServletResponse response) throws IOException {


        OssFileInformation firstByOssFileName = ossFileInformationRepository.findFirstByOssFileName(ossFileName);
        if (!Optional.ofNullable(firstByOssFileName).isPresent()){
            return R.error("error");
        }

        response.setHeader("Content-Disposition", "attachment;filename=" + new String(firstByOssFileName.getFileName().getBytes("UTF-8"), "ISO-8859-1"));

        ossFileInformationService.download(ossFileName,response.getOutputStream());

        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("status","1");
        hashMap.put("response","success");
        hashMap.put("ossFileInformationVO",firstByOssFileName);
        return R.ok().put("data",hashMap);
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
