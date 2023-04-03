package com.emergencyfood.PaimonTravelReservation.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.emergencyfood.PaimonTravelReservation.entity.LoginUser;
import com.emergencyfood.PaimonTravelReservation.entity.User;
import com.emergencyfood.PaimonTravelReservation.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper ;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        // 根据用户名查询用户数据
        LambdaQueryWrapper<User> lambdaQueryWrapper = Wrappers.<User>lambdaQuery().eq(User::getUserName,username);
        //大概可以理解成lambdaQueryWrapper是一条语句的条件部分，usermapper.select是语句的前半部分
        User user = userMapper.selectOne(lambdaQueryWrapper);




        // 如果查询不到数据，说明用户名或者密码错误，直接抛出异常
        if(user == null) {
            throw new RuntimeException("用户名或者密码错误") ;
        }

        // 将查询到的对象转换成Spring Security所需要的UserDetails对象
        return new LoginUser(user);

    }

}
