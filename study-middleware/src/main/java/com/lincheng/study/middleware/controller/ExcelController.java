package com.lincheng.study.middleware.controller;

import com.alibaba.fastjson.JSON;
import com.lincheng.study.common.domain.dubbo.vo.ProductVO;
import com.lincheng.study.common.domain.middleware.excel.vo.EasyPoiDemoAchievementVO;
import com.lincheng.study.common.domain.middleware.excel.vo.EasyPoiDemoVO;
import com.lincheng.study.common.utils.EasyPoiUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: linCheng
 * @create: 2021-10-12 15:08
 **/
@RestController
@RequestMapping("/easyPoi")
public class ExcelController {


    @RequestMapping("/export")
    public void export(HttpServletResponse response) {

        List<EasyPoiDemoVO> easyPoiDemoVOList = new ArrayList<>();
        EasyPoiDemoVO easyPoiDemoVO1 = new EasyPoiDemoVO();
        easyPoiDemoVO1.setId(1);
        easyPoiDemoVO1.setBirthday(new Date());
        easyPoiDemoVO1.setName("李四");
        easyPoiDemoVO1.setRegistrationDate("2021-10-14 22:17:06");
        easyPoiDemoVO1.setSex("1");
        easyPoiDemoVO1.setAge(9L);
        easyPoiDemoVO1.setNation("汉族");
        easyPoiDemoVO1.setRemark("导出时间设置,如果字段是Date类型则不需要设置 数据库如果是string类型,这个需要设置这个数据库格式,用以转换时间格式输出");
        EasyPoiDemoAchievementVO achievemen1 = new EasyPoiDemoAchievementVO();
        achievemen1.setChinese(20.0);
        achievemen1.setMath(30.0);
        achievemen1.setEnglish(10.0);
        easyPoiDemoVO1.setAchievemen(achievemen1);
        easyPoiDemoVOList.add(easyPoiDemoVO1);
        EasyPoiDemoVO easyPoiDemoVO2 = new EasyPoiDemoVO();
        easyPoiDemoVO2.setId(2);
        easyPoiDemoVO2.setBirthday(new Date());
        easyPoiDemoVO2.setName("王五");
        easyPoiDemoVO2.setRegistrationDate("2021-10-13 22:17:06");
        easyPoiDemoVO2.setSex("2");
        easyPoiDemoVO2.setAge(7L);
        easyPoiDemoVO2.setNation("苗族");
        EasyPoiDemoAchievementVO achievemen2 = new EasyPoiDemoAchievementVO();
        achievemen2.setChinese(50.0);
        achievemen2.setMath(70.0);
        achievemen2.setEnglish(6.5);
        easyPoiDemoVO2.setAchievemen(achievemen2);
        easyPoiDemoVOList.add(easyPoiDemoVO2);

        EasyPoiUtil.exportExcel(easyPoiDemoVOList, "easypoi导出功能(用户表)", "导出sheet1", EasyPoiDemoVO.class, "测试Users.xls", response);

    }



    @RequestMapping("/import")
    public void export(@RequestParam("file") MultipartFile file, ProductVO productVO) {
        System.out.println(JSON.toJSONString(productVO));

        List<EasyPoiDemoVO> easyPoiDemoVOS = EasyPoiUtil.importExcel(file, 2, EasyPoiDemoVO.class);

        System.out.println(JSON.toJSONString(easyPoiDemoVOS));
    }



}
