package com.lincheng.study.middleware.controller;

import com.lincheng.study.common.domain.middleware.excel.vo.StudentVO;
import com.lincheng.study.common.utils.ExcelUtils;
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

        List<StudentVO> studentVOList = new ArrayList<>();
        StudentVO studentVO1 = new StudentVO();
        studentVO1.setId(1);
        studentVO1.setBirthday(new Date());
        studentVO1.setName("李四");
        studentVO1.setRegistrationDate(new Date());
        studentVO1.setSex("1");
        studentVOList.add(studentVO1);
        StudentVO studentVO2 = new StudentVO();
        studentVO2.setId(2);
        studentVO2.setBirthday(new Date());
        studentVO2.setName("王五");
        studentVO2.setRegistrationDate(new Date());
        studentVO2.setSex("2");
        studentVOList.add(studentVO2);

        ExcelUtils.exportExcel(studentVOList, "easypoi导出功能(用户表)", "导出sheet1", StudentVO.class, "测试Users.xls", response);

    }


}
