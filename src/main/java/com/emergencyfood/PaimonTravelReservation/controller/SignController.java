package com.emergencyfood.PaimonTravelReservation.controller;

import com.emergencyfood.PaimonTravelReservation.commons.IdentifyCodeUtils;
import com.emergencyfood.PaimonTravelReservation.commons.RestResult;
import com.emergencyfood.PaimonTravelReservation.commons.SendEmailUtil;
import com.emergencyfood.PaimonTravelReservation.entity.User;
import com.emergencyfood.PaimonTravelReservation.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Api(tags = "注册")
@RestController
public class SignController {

    @Autowired
    UserServiceImpl userService;


    @Resource
    private SendEmailUtil emailUtil;

    @ApiOperation(value = "验证码接口",notes = "验证码接口")
    @PostMapping("/identifycode")
    public RestResult identifycode(HttpServletRequest request, @RequestParam String userMail){

        HttpSession session = request.getSession();
        String identifycode = IdentifyCodeUtils.getIdentifyCode();
        try{
            String title = "欢迎注册PaimonTravelReservationSystem!";
            String content = "您的注册验证码是："+identifycode+"\n"
                    +"请勿泄露！！！";
            emailUtil.sendMessage(userMail, title, content);
            session.setAttribute("identifycode",identifycode);
            return RestResult.success(null);
        }catch (Exception e){
            e.printStackTrace();
            return RestResult.fail(403,"邮件发送失败，请重试");
        }

    }

    @ApiOperation(value = "注册接口",notes = "注册接口")
    @PostMapping("/identifycodeSign")
    public RestResult signUp(HttpServletRequest request,@RequestParam String identifycode, @RequestBody  User user){

        System.out.println(identifycode);
        if (identifycode.equals((String) request.getSession().getAttribute("identifycode")) && user != null){


            System.out.println("进入了判断");
            userService.signup(user);
            return RestResult.success("注册成功");

        }
        else {

            return RestResult.fail(403,"验证码错误或者用户信息为空！");

        }



    }


}
