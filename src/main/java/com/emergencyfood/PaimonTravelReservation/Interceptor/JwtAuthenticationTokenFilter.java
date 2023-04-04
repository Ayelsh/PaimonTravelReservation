package com.emergencyfood.PaimonTravelReservation.Interceptor;

import com.alibaba.fastjson.JSON;
import com.emergencyfood.PaimonTravelReservation.commons.JWTUtil;
import com.emergencyfood.PaimonTravelReservation.entity.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Resource
    private RedisTemplate<String , String> redisTemplate ;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException, ServletException, IOException {


        // 1、从请求头中获取token，如果请求头中不存在token，直接放行即可！由Spring Security的过滤器进行校验！
        String token = request.getHeader("token");
        if(token == null || "".equals(token)) {
            filterChain.doFilter(request , response);

            return ;
        }

        // 2、对token进行解析，取出其中的userId
        String userId = null ;
        try {
            if (JWTUtil.verify(token)){
                System.out.println("Susscess");
            };
            userId= JWTUtil.getUserid(token);
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("token非法") ;
        }

        // 3、使用userId从redis中查询对应的LoginUser对象
        String loginUserJson = redisTemplate.boundValueOps("login_user:" + userId).get();
        LoginUser loginUser = JSON.parseObject(loginUserJson, LoginUser.class);
        if(loginUser != null) {
            // 4、然后将查询到的LoginUser对象的相关信息封装到UsernamePasswordAuthenticationToken对象中，然后将该对象存储到Security的上下文对象中
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser, null , null) ;
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
       
        // 5、放行
        filterChain.doFilter(request , response);
    }

}