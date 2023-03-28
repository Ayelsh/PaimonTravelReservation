package com.emergencyfood.PaimonTravelReservation.controller;

import com.emergencyfood.PaimonTravelReservation.commons.JudgeObjIsNullUtil;
import com.emergencyfood.PaimonTravelReservation.commons.ReturnObjects;
import com.emergencyfood.PaimonTravelReservation.service.impl.cityDataServicesImpl;
import com.emergencyfood.PaimonTravelReservation.service.impl.rotationChartServicesImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.beans.IntrospectionException;

@Api(tags = "主页")
@RestController
public class HomeController {

    @Resource
    rotationChartServicesImpl roationChart;

    @Resource
    cityDataServicesImpl cityData;



    @ApiOperation(value = "轮播图数据接口",notes = "用于获取轮播图数据")
    @GetMapping(value = "/rotationChartShow.do")
    public @ResponseBody
    Object rotationChartShow() throws IntrospectionException {

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
    Object cityDataShow() throws IntrospectionException {

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
}
