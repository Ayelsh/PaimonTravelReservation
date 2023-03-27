package com.emergencyfood.PaimonTravelReservation.controller;

import com.emergencyfood.PaimonTravelReservation.entity.RotationChart;
import com.emergencyfood.PaimonTravelReservation.service.impl.rotationChartImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Api(tags = "主页")
@RestController
public class HomeController {

    @Resource
    rotationChartImpl roationChart;

    @ApiOperation(value = "登录接口",notes = "登录接口的说明")
    @GetMapping(value = "/home")
    public @ResponseBody
    ArrayList<RotationChart> home(){


        return roationChart.getCharts();

    }
}
