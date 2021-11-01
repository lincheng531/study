package com.lincheng.study.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lincheng.study.mybatisplus.entity.StudyMybatisPlus;
import com.lincheng.study.mybatisplus.mapper.StudyMybatisPlusMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StudyMybatisPlusApplication.class)
public class StudyMybatisPlusApplicationTests {

    @Autowired
    private StudyMybatisPlusMapper studyMybatisPlusMapper;

    @Test
    public void contextLoads() {
        StudyMybatisPlus studyMybatisPlus = new StudyMybatisPlus();
        studyMybatisPlus.setAge(20);
        studyMybatisPlus.setEmail("2@qq.com");
        studyMybatisPlus.setName("张三");
        studyMybatisPlusMapper.insert(studyMybatisPlus);
    }

    @Test
    public void test1(){
        QueryWrapper<StudyMybatisPlus> queryWrapper = new QueryWrapper<>();
    }



}
