package com.lincheng.study.alioss.repository;

import com.lincheng.study.alioss.entity.OssFileInformation;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface OssFileInformationRepository extends PagingAndSortingRepository<OssFileInformation, Long> {

    OssFileInformation findFirstByMd5Hex(String md5Hex);

    OssFileInformation findFirstByOssFileName(String ossFileName);

    void deleteByOssFileName(String ossFileName);
}
