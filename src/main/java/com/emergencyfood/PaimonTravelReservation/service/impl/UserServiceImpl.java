package com.emergencyfood.PaimonTravelReservation.service.impl;

import com.alibaba.fastjson.JSON;
import com.emergencyfood.PaimonTravelReservation.commons.JWTUtil;
import com.emergencyfood.PaimonTravelReservation.commons.RestResult;
import com.emergencyfood.PaimonTravelReservation.entity.LoginUser;
import com.emergencyfood.PaimonTravelReservation.entity.User;
import com.emergencyfood.PaimonTravelReservation.mapper.UserMapper;
import com.emergencyfood.PaimonTravelReservation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AuthenticationManager authenticationManager ;

    @Resource
    private RedisTemplate<String , String> redisTemplate ;

    @Autowired
    UserMapper userMapper;

    @Override
    public RestResult login(User user) {


        // 创建Authentication对象
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName() , user.getPassword()) ;

        // 调用AuthenticationManager的authenticate方法进行认证
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        if(authentication == null) {
            throw new RuntimeException("用户名或密码错误");
        }


        // 将用户的数据存储到Redis中
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        String userId = loginUser.getUser().getId().toString();

        try {
            redisTemplate.boundValueOps("login_user:" + userId).set(JSON.toJSONString(loginUser));
        }
        catch (Exception e){
            e.printStackTrace();
        }



        // 生成JWT令牌并进行返回


        String token = JWTUtil.jwtCreate(userId);


        // 构建返回数据
        Map<String , String> result = new HashMap<>();
        result.put("token" , token) ;
        return RestResult.success(result);

    }


    @Override
    public RestResult logout() {

        // 获取登录的用户信息
        LoginUser loginUser = (LoginUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long userId = loginUser.getUser().getId();

        // 删除Redis中的用户数据
        redisTemplate.delete("login_user:" + userId) ;

        // 返回
        return RestResult.success(null);

    }

    @Override
    public RestResult signup(User user) {

        String password = user.getPassword();
        password = new BCryptPasswordEncoder().encode(password);
        user.setPassword(password);
        Integer result = userMapper.insert(user);
        if (result == 1){
            return RestResult.success("Sign_SUCCESS");
        }else return RestResult.fail(403,"数据库插入失败");
    }
}