package com.lincheng.study.alioss.repository;

import com.lincheng.study.alioss.entity.OssFileBusiness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OssFileBusinessRepository  extends JpaRepository<OssFileBusiness, Long> {


    List<OssFileBusiness> findAllByOssFileBusinessIdIn(List<Long> ossFileBusinessIdList);

}
