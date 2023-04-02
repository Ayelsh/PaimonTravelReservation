package com.emergencyfood.PaimonTravelReservation.controller;

import com.emergencyfood.PaimonTravelReservation.commons.JWTUtil;
import com.emergencyfood.PaimonTravelReservation.commons.RestResult;
import com.emergencyfood.PaimonTravelReservation.commons.RestWrapper;
import com.emergencyfood.PaimonTravelReservation.entity.User;
import com.emergencyfood.PaimonTravelReservation.service.UserService;
import org.apache.ibatis.annotations.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


@RestController
@RestWrapper
public class LoginController {

    @Resource
    UserService userService;

    @PostMapping(value = "/login")
    public RestResult login(@RequestBody User userDTO) {
        User user = userService.login(userDTO);
        if (user != null) {

            Map<String, Object> data = new HashMap<>();
            data.put("user", user);
            data.put("token", JWTUtil.jwtCreate(user.getUsername()));
            return RestResult.success(data);
        }
        return RestResult.fail(400, "fail");
    }
}
