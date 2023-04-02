package com.emergencyfood.PaimonTravelReservation.service;

import com.emergencyfood.PaimonTravelReservation.commons.JWTUtil;
import com.emergencyfood.PaimonTravelReservation.entity.RequestContext;
import com.emergencyfood.PaimonTravelReservation.entity.User;
import com.emergencyfood.PaimonTravelReservation.mapper.userDataMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    userDataMapper userDataMapper;


    public User login(User userDTO) {

        User user = userDataMapper.selectByUsername(userDTO.getUsername());
        //模拟登录
        if (user.getId()!= null && userDTO.getPassword().equals(user.getPassword())) {
            return user;
        }
        return null;
    }

//    public User info() {
//        String token = RequestContext.get();
//        String username = JWTUtil.getUsername(token);
//        if (username.equals(user.getUsername())) {
//            return user;
//        }
//        return null;
//    }
}
