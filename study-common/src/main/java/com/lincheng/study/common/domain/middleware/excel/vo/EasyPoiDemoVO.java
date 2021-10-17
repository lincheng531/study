package com.lincheng.study.common.domain.middleware.excel.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:
 *      @Excel 属性说明
 *          name：表头名称
 *          orderNum：列的序号（在第几列）
 *          replace：值得替换，导出是{"男_1", "女_2"} 导入反过来
 *          width：列宽
 *          height：列高
 *          format：时间格式
 *          databaseFormat：导出时间设置,如果字段是Date类型则不需要设置 数据库如果是string类型,这个需要设置这个数据库格式,用以转换时间格式输出
 *          suffix: 文字后缀, 如90 变成90%
 *          isColumnHidden：true为导出隐藏此列
 *          isImportField：true此列必须存在，false此列可以不存在
 *          isStatistics： true自动统计数据（总和）
 *          isWrap：是否换行
 *
 *
 * @author: linCheng
 * @create: 2021-10-12 15:15
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class EasyPoiDemoVO implements Serializable {

    @Excel(name = "序号",  orderNum = "0" , width = 10)
    private Integer id;

    @Excel(name = "姓名", orderNum = "1", width = 30)
    private String name;

    @Excel(name = "性别", orderNum = "2", width = 30, replace = {"男_1", "女_2"}, suffix = "性")
    private String sex;

    @Excel(name = "生日", orderNum = "5", width = 30, format = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;

    @Excel(name = "进校日期", orderNum = "4", width = 30, databaseFormat = "yyyyMMddHHmmss", format = "yyyy-MM-dd" )
    private String registrationDate;

    @Excel(name = "年龄", orderNum = "3", width = 30)
    private Long age;

    @Excel(name = "民族", orderNum = "6", width = 30, isColumnHidden = true)
    private String nation;

    @ExcelEntity(name = "成绩")
    private EasyPoiDemoAchievementVO achievemen;

    @Excel(name = "备注", orderNum = "8",  width = 30, isWrap = true)
    private String remark;


}
