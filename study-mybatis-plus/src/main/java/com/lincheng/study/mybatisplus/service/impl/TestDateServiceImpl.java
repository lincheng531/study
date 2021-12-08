package com.lincheng.study.mybatisplus.service.impl;

import com.lincheng.study.mybatisplus.entity.TestDate;
import com.lincheng.study.mybatisplus.mapper.TestDateMapper;
import com.lincheng.study.mybatisplus.service.ITestDateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 测试时间 服务实现类
 * </p>
 *
 * @author linCheng
 * @since 2021-12-08
 */
@Service
public class TestDateServiceImpl extends ServiceImpl<TestDateMapper, TestDate> implements ITestDateService {

}
