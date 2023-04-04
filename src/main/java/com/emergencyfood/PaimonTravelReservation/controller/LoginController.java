package com.emergencyfood.PaimonTravelReservation.controller;

import com.emergencyfood.PaimonTravelReservation.commons.JWTUtil;
import com.emergencyfood.PaimonTravelReservation.commons.RestResult;
import com.emergencyfood.PaimonTravelReservation.commons.RestWrapper;
import com.emergencyfood.PaimonTravelReservation.entity.User;
import com.emergencyfood.PaimonTravelReservation.service.UserService;
import com.emergencyfood.PaimonTravelReservation.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "登录")
@RestController
@RequestMapping(value = "/PaimonTravelReservation")
public class LoginController {

    @Resource
    UserServiceImpl userService;

    @ApiOperation(value = "登录接口",notes = "登录接口")
    @PostMapping(value = "/login")
    public RestResult login(@RequestBody User user) {

        System.out.println("访问了一次登录接口");
        return userService.login(user);
    }
}
