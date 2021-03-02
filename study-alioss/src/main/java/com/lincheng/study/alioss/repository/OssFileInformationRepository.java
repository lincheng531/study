package com.lincheng.study.alioss.repository;

import com.lincheng.study.alioss.entity.OssFileInformation;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface OssFileInformationRepository extends PagingAndSortingRepository<OssFileInformation, Long> {

    OssFileInformation findFirstByMd5Hex(String md5Hex);

    OssFileInformation findFirstByOssFileName(String ossFileName);

    @Transactional
    void deleteByOssFileName(String ossFileName);
}
