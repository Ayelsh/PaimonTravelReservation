package com.emergencyfood.PaimonTravelReservation.controller;


import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.emergencyfood.PaimonTravelReservation.commons.RestResult;
import com.emergencyfood.PaimonTravelReservation.commons.RestWrapper;
import com.emergencyfood.PaimonTravelReservation.commons.SendEmailUtil;
import com.emergencyfood.PaimonTravelReservation.entity.Fligts;
import com.emergencyfood.PaimonTravelReservation.service.impl.cityDataServicesImpl;
import com.emergencyfood.PaimonTravelReservation.service.impl.fligtsServicesImpl;
import com.emergencyfood.PaimonTravelReservation.service.impl.rotationChartServicesImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestWrapper
@Api(tags = "主页")
@RestController()
@RequestMapping(value = "/PaimonTravelReservation")
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
    public Object rotationChartShow(HttpServletRequest request){


        MDC.put("reqId", request.getSession().getId());
        log.info("用户访问了一次轮播数据接口");


        if (roationChart.getCharts().toString().equals("[]")){
            return RestResult.fail(404,"查找的数据为空");
        }
        else{
            return roationChart.getCharts();

        }


    }


    @ApiOperation(value = "城市数据展示接口",notes = "用于获取城市数据")
    @GetMapping(value = "/cityDataShow.do")
    public Object cityDataShow(HttpServletRequest request){

        MDC.put("reqId", request.getSession().getId());
        log.info("用户访问了一次轮播数据接口");


        if (cityData.getCity().toString().equals("[]") ? true : false){

            return RestResult.fail(404,"查找的数据为空");

        }
        else{
            return cityData.getCity();
        }


    }



    @ApiOperation(value = "可选航班数据展示接口",notes = "用于获取可选航班数据")
    @GetMapping(value = "/fligtsShow.do/{FromCity}/{ToCity}/{DepartTime}/{ReturnTime}/{PassengerNum}/{ClassType}")
    public Object fligtsShow(HttpServletRequest request,@PathVariable("FromCity") String FromCity , @PathVariable("ToCity")String ToCity ,
                      @PathVariable("DepartTime") String DepartTime , @PathVariable("ReturnTime") String ReturnTime ,
                      @PathVariable("PassengerNum")int PassengerNum, @PathVariable("ClassType")String ClassType){

        MDC.put("reqId", request.getSession().getId());
        log.info("用户访问了一次轮播数据接口");


        DateTime departTime = DateUtil.parse(DepartTime);
        DateTime returnTime = DateUtil.parse(ReturnTime);



        List<Fligts> fligts = fligtsData.getFligts(FromCity,ToCity,departTime,returnTime,PassengerNum,ClassType);

        System.out.println(FromCity+ToCity+departTime+returnTime+PassengerNum+ClassType);

        if (fligts.toString().equals("[]") ? true : false){

            return RestResult.fail(404,"查找的数据为空");


        }
        else{
            return fligts;
        }


    }

    @ApiOperation(value = "邮箱接口",notes = "邮箱接口")
    @PostMapping(value = "/mail.do")
    public void mailSend(HttpServletRequest request,
                         @RequestParam String userMail){

        MDC.put("reqId", request.getSession().getId());
        log.info("用户访问了一次轮播数据接口");

        String title = "欢迎注册PaimonTravelReservationSystem!";
        String content = "文本邮件发送测试";
        emailUtil.sendMessage(userMail, title, content);

    }








}
