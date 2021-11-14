package com.lincheng.study.security.service.impl;

import com.lincheng.study.security.service.interfaces.IAccessService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * @author lincheng5
 * @date 2021/11/14 17:39
 */
@Service
public class AccessServiceImpl implements IAccessService {


    @Override
    public Boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        String uri = request.getRequestURI();
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails){
            UserDetails userDetails = (UserDetails) principal;
            Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
            return authorities.contains(new SimpleGrantedAuthority(uri));
        }
        return false;
    }
}
