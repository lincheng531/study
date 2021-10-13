package com.lincheng.study.common.domain.middleware.excel.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:
 * @author: linCheng
 * @create: 2021-10-12 15:15
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class StudentVO implements Serializable {

    @Excel(name = "序号", width = 10) //后期controller中将为id字段重新赋值，实现序号效果
    private Integer id;

    @Excel(name = "姓名", orderNum = "0", width = 30)
    private String name;

    @Excel(name = "性别", replace = {"男_1", "女_2"}, orderNum = "1", width = 30, suffix = "性")
    private String sex;

    @Excel(name = "生日", format = "yyyy-MM-dd HH:mm:ss", orderNum = "2", width = 30)
    private Date birthday;

    @Excel(name = "进校日期", databaseFormat = "yyyyMMddHHmmss", format = "yyyy-MM-dd", orderNum = "4" )
    private Date registrationDate;

}
