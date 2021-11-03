package com.lincheng.study.mybatisplus;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lincheng.study.mybatisplus.entity.StudyMybatisPlus;
import com.lincheng.study.mybatisplus.entity.StudyMybatisPlusAr;
import com.lincheng.study.mybatisplus.mapper.StudyMybatisPlusArMapper;
import com.lincheng.study.mybatisplus.mapper.StudyMybatisPlusMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StudyMybatisPlusApplication.class)
public class StudyMybatisPlusApplicationTests {

    @Resource
    private StudyMybatisPlusMapper studyMybatisPlusMapper;

    @Resource
    private StudyMybatisPlusArMapper studyMybatisPlusArMapper;

    @Test
    public void contextLoads() {
        StudyMybatisPlus studyMybatisPlus = new StudyMybatisPlus();
        studyMybatisPlus.setAge(20);
        studyMybatisPlus.setEmail("2@qq.com");
        studyMybatisPlus.setName("张三");
        studyMybatisPlusMapper.insert(studyMybatisPlus);
    }



    @Test
    public void arInsert(){
        StudyMybatisPlusAr studyMybatisPlusAr = new StudyMybatisPlusAr();
        studyMybatisPlusAr.setCreateTime(new Date());
        studyMybatisPlusAr.setMobile("159");
        studyMybatisPlusAr.setStudyAr("学习一下哈哈哈");
        studyMybatisPlusAr.setName("张三");
        studyMybatisPlusAr.insert();
    }

    @Test
    public void arUpdate(){
        StudyMybatisPlusAr studyMybatisPlusAr = new StudyMybatisPlusAr();
        studyMybatisPlusAr.setId(1);
        studyMybatisPlusAr.setCreateTime(new Date());
        studyMybatisPlusAr.setMobile("1586600");
        studyMybatisPlusAr.setStudyAr("");
        studyMybatisPlusAr.setName("张四");
        studyMybatisPlusAr.insertOrUpdate();
    }


    @Test
    public void testMapper(){
        List<StudyMybatisPlusAr> studyMybatisPlusArs = studyMybatisPlusArMapper.selectArByName("张三");
        System.out.println(studyMybatisPlusArs);
        StudyMybatisPlusAr studyMybatisPlusAr = studyMybatisPlusArMapper.selectArById(1);
        System.out.println(studyMybatisPlusAr);
    }


    @Test
    public void testQueryWrapperAllEq(){


        QueryWrapper<StudyMybatisPlusAr> queryWrapper = new QueryWrapper<>();
        Map<String,Object> map = new HashMap<>();
        map.put("STUDY_AR","学习一下哈哈哈");
        queryWrapper.allEq(map);
        //null2IsNull : 为true则在map的value为null时调用 isNull 方法,为false时则忽略
        //queryWrapper.allEq(map,false);
        List<StudyMybatisPlusAr> studyMybatisPlusArs = studyMybatisPlusArMapper.selectList(queryWrapper);
        System.out.println(JSON.toJSONString(studyMybatisPlusArs));
    }


    @Test
    public void testQueryWrapperEq(){
        QueryWrapper<StudyMybatisPlusAr> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("MOBILE","1586600");
        queryWrapper.ne("NAME","999");
        List<StudyMybatisPlusAr> studyMybatisPlusArs = studyMybatisPlusArMapper.selectList(queryWrapper);
        System.out.println(JSON.toJSONString(studyMybatisPlusArs));
    }

    @Test
    public void testQueryWrapperOr(){
        QueryWrapper<StudyMybatisPlusAr> queryWrapper = new QueryWrapper<>();

        //SELECT * FROM study_mybatis_plus_ar WHERE (MOBILE = ? OR MOBILE = ?)
        //queryWrapper.eq("MOBILE","1586600").or().eq("MOBILE","158");


        //SELECT * FROM study_mybatis_plus_ar WHERE ((MOBILE = ? OR MOBILE = ?) AND (NAME = ? OR NAME = ?))
        queryWrapper.and(i -> i.eq("MOBILE", "1586600").or().eq("MOBILE", "158"))
                .and(i -> i.eq("NAME", "张四").or().eq("NAME", "赵五"));

        List<StudyMybatisPlusAr> studyMybatisPlusArs = studyMybatisPlusArMapper.selectList(queryWrapper);
        System.out.println(JSON.toJSONString(studyMybatisPlusArs));
    }

    @Test
    public void testQueryWrapperLast(){
        QueryWrapper<StudyMybatisPlusAr> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("MOBILE","1586600").or().eq("MOBILE","158").last("limit 1");
        List<StudyMybatisPlusAr> studyMybatisPlusArs = studyMybatisPlusArMapper.selectList(queryWrapper);
        System.out.println(JSON.toJSONString(studyMybatisPlusArs));
    }


    @Test
    public void testPage(){
        QueryWrapper<StudyMybatisPlusAr> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("AGE","20");

        Page<StudyMybatisPlusAr> page = new Page<>();
        //第几页
        page.setCurrent(2);
        //每页大小
        page.setSize(3);
        IPage<StudyMybatisPlusAr> result = studyMybatisPlusArMapper.selectPage(page, queryWrapper);

        List<StudyMybatisPlusAr> records = result.getRecords();
        System.out.println("结果集："+JSON.toJSONString(records));
        System.out.println("总页数："+result.getPages());
        System.out.println("总数 count："+result.getTotal());
        System.out.println("当前第几页："+result.getCurrent());
        System.out.println("每页大小："+result.getSize());
    }


    @Test
    public void testPageByCustom(){
        Page<StudyMybatisPlusAr> page = new Page<>();
        //第几页
        page.setCurrent(2);
        //每页大小
        page.setSize(3);

        IPage<StudyMybatisPlusAr> result = studyMybatisPlusArMapper.selectArByState(page, "1");

        List<StudyMybatisPlusAr> records = result.getRecords();
        System.out.println("结果集："+JSON.toJSONString(records));
        System.out.println("总页数："+result.getPages());
        System.out.println("总数 count："+result.getTotal());
        System.out.println("当前第几页："+result.getCurrent());
        System.out.println("每页大小："+result.getSize());
    }


}
