package com.lincheng.study.mybatis.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lincheng.study.mybatis.dao.CCustDao;
import com.lincheng.study.mybatis.domain.CustRequest;
import com.lincheng.study.mybatis.entity.CCust;
import com.lincheng.study.mybatis.entity.CCustExample;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mybatis")
public class CustController {

    @Resource
    private CCustDao cCustMapper;

    @RequestMapping("/insert")
    private Object insert(@RequestBody CCust cCust){


        return Optional.ofNullable(cCust.getCustId()).map(e -> {
            cCust.setCustName("update");
            cCustMapper.updateByPrimaryKey(cCust);
            return cCust;
        }).orElseGet(() -> {
            cCust.setCustName("insert");
            cCustMapper.insert(cCust);
            return cCust;
        });
    }


    @RequestMapping("/page")
    private Object page(@RequestBody CustRequest custRequest){


        PageHelper.startPage(custRequest.getPageNum(),custRequest.getPageSize());
        CCustExample example = new CCustExample();
        List<CCust> cCusts = cCustMapper.selectByExample(example);

        PageInfo<CCust> pageInfo=new PageInfo(cCusts);
        return pageInfo;
    }

}
