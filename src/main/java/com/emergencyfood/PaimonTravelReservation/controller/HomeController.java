package com.emergencyfood.PaimonTravelReservation.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(tags = "主页")
@Controller
public class HomeController {

    @GetMapping(value = "/home")
    public @ResponseBody String home(){
        return "Hello world!";

    }
}
