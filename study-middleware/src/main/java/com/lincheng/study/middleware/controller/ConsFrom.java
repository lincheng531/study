package com.lincheng.study.middleware.controller;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * @description:
 * @author: linCheng
 * @create: 2022-06-24 15:13
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ConsFrom {

    @Excel(name = "*户号",  orderNum = "0")
    private String consNo;

    @Excel(name = "户名",  orderNum = "1")
    private String consName;

    @Excel(name = "最大负荷（kW）",  orderNum = "2")
    private BigDecimal maxLoadPower;

    @Excel(name = "最小负荷（kW）",  orderNum = "3")
    private BigDecimal minLoadPower;

    @Excel(name = "时段分类",  orderNum = "4")
    private String timeInterClass;

    @Excel(name = "时段分类",  orderNum = "5")
    private BigDecimal securityLoad;

    @Excel(name = "*最大可控负荷（kW）",  orderNum = "6")
    private BigDecimal maxCtrlPower;

    @Excel(name = "标签1",  orderNum = "7")
    private String tagName1;

    @Excel(name = "*标签2",  orderNum = "8")
    private String tagName2;

}

