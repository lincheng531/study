package com.lincheng.study.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lincheng.study.mybatisplus.entity.StudyMybatisPlusAr;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lincheng5
 * @date 2021/11/3 21:35
 */
public interface StudyMybatisPlusArMapper extends BaseMapper<StudyMybatisPlusAr> {

    StudyMybatisPlusAr selectArById(@Param("id") Integer id);

    List<StudyMybatisPlusAr> selectArByName(@Param("name") String name);

    IPage<StudyMybatisPlusAr> selectArByState(Page<?> page, @Param("state") String state);
}
