package com.lincheng.study.security.service.interfaces;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lincheng5
 * @date 2021/11/14 17:39
 */
public interface IAccessService {

    Boolean hasPermission(HttpServletRequest request, Authentication authentication);
}
