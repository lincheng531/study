package com.lincheng.study.alioss.service;


import com.google.common.collect.Lists;
import com.lincheng.study.alioss.entity.OssFileBusiness;
import com.lincheng.study.alioss.repository.OssFileBusinessRepository;
import com.lincheng.study.common.domain.alioss.vo.OssFileBusinessVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class OssfileBusinessService {


    @Resource
    private OssFileBusinessRepository ossFileBusinessRepository;

    @Resource
    private OssFileInformationService ossFileInformationService;

    public void saveOssFileBusiness(List<OssFileBusinessVO> ossFileBusinessVOList){

        List<OssFileBusiness> ossFileBusinessList = new ArrayList<>();

        ossFileBusinessVOList.forEach(ossFileBusinessVO -> {
            OssFileBusiness ossFileBusiness = new OssFileBusiness();
            ossFileBusinessVO.setBusinessType(1);
            BeanUtils.copyProperties(ossFileBusinessVO,ossFileBusiness);
            ossFileBusinessList.add(ossFileBusiness);
        });

        ossFileBusinessRepository.saveAll(ossFileBusinessList);

    }

    public void deleteOssFileBusiness(List<Long> ossFileBusinessIdList){

        List<OssFileBusiness> ossFileBusinessList = ossFileBusinessRepository.findAllByOssFileBusinessIdIn(ossFileBusinessIdList);


        List<Long> ossFileInfoIds =  Lists.newArrayList();
        ossFileBusinessList.forEach(ossFileBusiness -> ossFileInfoIds.add(ossFileBusiness.getOssFileInfoId()));

        //删除文件信息表
        //ossFileInformationService.delete(ossFileInfoIds);
        //删除文件业务表
        ossFileBusinessRepository.deleteAll(ossFileBusinessList);

    }





}
