package com.lincheng.study.mybatis.generator.dao;

import com.lincheng.study.mybatis.generator.entity.CcAgent;
import com.lincheng.study.mybatis.generator.entity.CcAgentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CcAgentMapper {
    int countByExample(CcAgentExample example);

    int deleteByExample(CcAgentExample example);

    int deleteByPrimaryKey(Integer agentId);

    int insert(CcAgent record);

    int insertSelective(CcAgent record);

    List<CcAgent> selectByExample(CcAgentExample example);

    CcAgent selectByPrimaryKey(Integer agentId);

    int updateByExampleSelective(@Param("record") CcAgent record, @Param("example") CcAgentExample example);

    int updateByExample(@Param("record") CcAgent record, @Param("example") CcAgentExample example);

    int updateByPrimaryKeySelective(CcAgent record);

    int updateByPrimaryKey(CcAgent record);
}