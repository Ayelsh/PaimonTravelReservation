package com.emergencyfood.PaimonTravelReservation.Interceptor;

import com.emergencyfood.PaimonTravelReservation.commons.JWTUtil;
import com.emergencyfood.PaimonTravelReservation.entity.RequestContext;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtIntercepter implements HandlerInterceptor {
	//主要功能拦截请求验证token
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {



        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            throw new IllegalArgumentException("token 不能为空");
        }
        if (!JWTUtil.verify(token)) {
            throw new IllegalArgumentException("token 验证失败，请重新登录！");
        }
        RequestContext.set(token);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        RequestContext.remove();
    }
}

