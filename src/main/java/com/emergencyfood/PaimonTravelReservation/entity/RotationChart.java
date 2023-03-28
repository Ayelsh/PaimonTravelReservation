package com.emergencyfood.PaimonTravelReservation.entity;


import io.swagger.annotations.ApiModel;
import lombok.Data;



@Data
@ApiModel(value="轮播图对象",description="轮播图对象")
public class RotationChart {

    private Integer goodsId;

    private String imageSrc;

    private String openType;

    private String navigatorUrl;




}