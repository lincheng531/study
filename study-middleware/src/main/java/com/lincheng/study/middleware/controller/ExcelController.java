package com.lincheng.study.middleware.controller;

import com.lincheng.study.common.domain.middleware.excel.vo.EasyPoiDemoVO;
import com.lincheng.study.common.utils.EasyPoiUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/excel")
public class ExcelController {


    @RequestMapping("/export")
    public void export(HttpServletResponse response) {

        List<EasyPoiDemoVO> easyPoiDemoVOList = new ArrayList<>();
        EasyPoiDemoVO easyPoiDemoVO1 = new EasyPoiDemoVO();
        easyPoiDemoVO1.setId(1);
        easyPoiDemoVO1.setBirthday(new Date());
        easyPoiDemoVO1.setName("李四");
        easyPoiDemoVO1.setRegistrationDate(new Date());
        easyPoiDemoVO1.setSex("1");
        easyPoiDemoVOList.add(easyPoiDemoVO1);
        EasyPoiDemoVO easyPoiDemoVO2 = new EasyPoiDemoVO();
        easyPoiDemoVO2.setId(2);
        easyPoiDemoVO2.setBirthday(new Date());
        easyPoiDemoVO2.setName("王五");
        easyPoiDemoVO2.setRegistrationDate(new Date());
        easyPoiDemoVO2.setSex("2");
        easyPoiDemoVOList.add(easyPoiDemoVO2);

        EasyPoiUtil.exportExcel(easyPoiDemoVOList, "easypoi导出功能(用户表)", "导出sheet1", EasyPoiDemoVO.class, "测试Users.xls", response);

    }


}
