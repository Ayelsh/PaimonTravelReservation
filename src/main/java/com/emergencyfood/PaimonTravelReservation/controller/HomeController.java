package com.emergencyfood.PaimonTravelReservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping(value = "/home")
    public @ResponseBody String home(){
        return "Hello world!";

    }
}
