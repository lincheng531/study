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
 * @create: 2022-06-24 15:22
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class SwtichRoundLoadPowerFrom {

    @Excel(name = "*终端编号",  orderNum = "0")
    private String treminalId;

    @Excel(name = "*轮次号",  orderNum = "1")
    private String switchRoundNo;

    @Excel(name = "*轮次名称",  orderNum = "2")
    private String switchRoundName;

    @Excel(name = "负荷性质",  orderNum = "3")
    private String loadPowerProp;

    @Excel(name = "负荷重要性等级",  orderNum = "4")
    private String loadPowerLevel;

    @Excel(name = "可中断级别",  orderNum = "5")
    private String interLevel;

    @Excel(name = "是否有效",  orderNum = "6")
    private String isValid;

    @Excel(name = "设备运行特点",  orderNum = "7")
    private String devRunFeature;

    @Excel(name = "设备跳闸风险描述",  orderNum = "8")
    private String tripRisk;

    @Excel(name = "早峰最大可控负荷",  orderNum = "9")
    private BigDecimal withinMorningLoad;

    @Excel(name = "腰峰最大可控负荷",  orderNum = "10")
    private BigDecimal withinWaistLoad;

    @Excel(name = "晚峰最大可控负荷",  orderNum = "11")
    private BigDecimal withinNightLoad;

    @Excel(name = "其他时段最大可控负荷",  orderNum = "12")
    private BigDecimal withinOtherLoad;

    @Excel(name = "早峰最大可控负荷",  orderNum = "13")
    private BigDecimal aboveMorningLoad;

    @Excel(name = "腰峰最大可控负荷",  orderNum = "14")
    private BigDecimal aboveWaistLoad;

    @Excel(name = "晚峰最大可控负荷",  orderNum = "15")
    private BigDecimal aboveNightLoad;

    @Excel(name = "其他时段最大可控负荷",  orderNum = "16")
    private BigDecimal aboveOtherLoad;

}
