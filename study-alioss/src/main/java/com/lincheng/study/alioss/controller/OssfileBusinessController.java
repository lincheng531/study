package com.lincheng.study.alioss.controller;

import com.lincheng.study.common.domain.alioss.vo.OssFileBusinessVO;
import com.lincheng.study.common.utils.R;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OssfileBusinessController {


    @RequestMapping("fileBusiness/save")
    public R ossUpload(@RequestBody OssFileBusinessVO ossFileBusinessVO) throws Exception {



        return null;
    }


}
