package com.lincheng.study.common.domain.rocket.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author linCheng
 * @date 2021/5/26 13:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageVO {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 内容
     */
    private String context;
}
