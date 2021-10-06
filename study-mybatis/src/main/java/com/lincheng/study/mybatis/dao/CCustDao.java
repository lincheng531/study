package com.lincheng.study.mybatis.dao;

import com.lincheng.study.mybatis.entity.CCust;
import com.lincheng.study.mybatis.entity.CCustExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CCustDao {
    int countByExample(CCustExample example);

    int deleteByExample(CCustExample example);

    int deleteByPrimaryKey(Long custId);

    int insert(CCust record);

    int insertSelective(CCust record);

    List<CCust> selectByExample(CCustExample example);

    CCust selectByPrimaryKey(Long custId);

    int updateByExampleSelective(@Param("record") CCust record, @Param("example") CCustExample example);

    int updateByExample(@Param("record") CCust record, @Param("example") CCustExample example);

    int updateByPrimaryKeySelective(CCust record);

    int updateByPrimaryKey(CCust record);
}