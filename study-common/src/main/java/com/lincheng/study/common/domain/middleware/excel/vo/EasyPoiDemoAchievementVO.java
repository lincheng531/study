package com.lincheng.study.common.domain.middleware.excel.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author lincheng5
 * @date 2021/10/18 0:01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class EasyPoiDemoAchievementVO {
    @Excel(name = "语文", orderNum = "10", isStatistics = true)
    private Double chinese;

    @Excel(name = "数学", orderNum = "11", isStatistics = true)
    private Double math;

    @Excel(name = "英语", orderNum = "12", isStatistics = true)
    private Double english;
}
