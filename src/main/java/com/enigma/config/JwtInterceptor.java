package com.enigma.config;

import com.enigma.shared.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {
//    @Autowired
//    JwtUtils jwtUtils;
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        if (request.getRequestURI().contains("login")) {
//            return true;
//        }
//        return jwtUtils.validateToken(request.getHeader("Authorization"));
//    }
}
