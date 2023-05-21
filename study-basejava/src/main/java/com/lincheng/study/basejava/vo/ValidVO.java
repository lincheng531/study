package com.lincheng.study.basejava.vo;

import javax.validation.constraints.NotEmpty;

/**
 * @description:
 * @author: linCheng
 * @create: 2022-03-25 11:41
 **/
public class ValidVO {

    @NotEmpty(message = "不能为空")
    private String name;
    //@Length(max = 10,min = 6,message = "长度10，到6")
    private String phone;
    private String age;


}
