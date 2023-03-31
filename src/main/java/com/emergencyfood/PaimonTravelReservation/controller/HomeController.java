package com.emergencyfood.PaimonTravelReservation.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.emergencyfood.PaimonTravelReservation.commons.JudgeObjIsNullUtil;
import com.emergencyfood.PaimonTravelReservation.commons.ReturnObjects;
import com.emergencyfood.PaimonTravelReservation.commons.SendEmailUtil;
import com.emergencyfood.PaimonTravelReservation.entity.Fligts;
import com.emergencyfood.PaimonTravelReservation.service.impl.cityDataServicesImpl;
import com.emergencyfood.PaimonTravelReservation.service.impl.fligtsServicesImpl;
import com.emergencyfood.PaimonTravelReservation.service.impl.rotationChartServicesImpl;
import com.mysql.cj.AbstractQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.slf4j.MDC;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.beans.IntrospectionException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Api(tags = "主页")
@RestController
public class HomeController {

    @Resource
    rotationChartServicesImpl roationChart;

    @Resource
    cityDataServicesImpl cityData;

    @Resource
    fligtsServicesImpl fligtsData;

    @Resource
    private SendEmailUtil emailUtil;



    @ApiOperation(value = "轮播图数据接口",notes = "用于获取轮播图数据")
    @GetMapping(value = "/rotationChartShow.do")
    public @ResponseBody
    Object rotationChartShow(HttpServletRequest request){


        MDC.put("reqId", request.getSession().getId());
        log.info("用户访问了一次轮播数据接口");


        ReturnObjects returnObjects = new ReturnObjects();

        if (roationChart.getCharts().toString().equals("[]")){

            returnObjects.setCode("400");
            returnObjects.setMessage("查找为空");

        }
        else{
            returnObjects.setCode("200");
            returnObjects.setMessage("获取成功！");
            returnObjects.setRetData(roationChart.getCharts());

        }
        return returnObjects;

    }


    @ApiOperation(value = "城市数据展示接口",notes = "用于获取城市数据")
    @GetMapping(value = "/cityDataShow.do")
    public @ResponseBody
    Object cityDataShow(){

        ReturnObjects returnObjects = new ReturnObjects();

        if (cityData.getCity().toString().equals("[]") ? true : false){

            returnObjects.setCode("400");
            returnObjects.setMessage("查找为空");

        }
        else{
            returnObjects.setCode("200");
            returnObjects.setMessage("获取成功！");
            returnObjects.setRetData(cityData.getCity());

        }
        return returnObjects;

    }


    @ApiOperation(value = "可选航班数据展示接口",notes = "用于获取可选航班数据")
    @GetMapping(value = "/fligtsShow.do/{FromCity}/{ToCity}/{DepartTime}/{ReturnTime}/{PassengerNum}/{ClassType}")
    public @ResponseBody
    Object fligtsShow(@PathVariable("FromCity") String FromCity , @PathVariable("ToCity")String ToCity ,
                      @PathVariable("DepartTime") String DepartTime , @PathVariable("ReturnTime") String ReturnTime ,
                      @PathVariable("PassengerNum")int PassengerNum, @PathVariable("ClassType")String ClassType){

        ReturnObjects returnObjects = new ReturnObjects();


        DateTime departTime = DateUtil.parse(DepartTime);
        DateTime returnTime = DateUtil.parse(ReturnTime);



        List<Fligts> fligts = fligtsData.getFligts(FromCity,ToCity,departTime,returnTime,PassengerNum,ClassType);

        System.out.println(FromCity+ToCity+departTime+returnTime+PassengerNum+ClassType);

        if (fligts.toString().equals("[]") ? true : false){

            returnObjects.setCode("401");
            returnObjects.setMessage("没有符合条件的航班信息");
            System.out.println(fligts);

        }
        else{
            returnObjects.setCode("200");
            returnObjects.setMessage("获取成功！");
            returnObjects.setRetData(fligts);

        }
        return returnObjects;

    }

    @ApiOperation(value = "邮箱接口",notes = "邮箱接口")
    @PostMapping(value = "/mail.do")
    public void mailSend(@RequestParam String userMail){

        String title = "欢迎注册PaimonTravelReservationSystem!";
        String content = "文本邮件发送测试";
        emailUtil.sendMessage(userMail, title, content);

    }








}
