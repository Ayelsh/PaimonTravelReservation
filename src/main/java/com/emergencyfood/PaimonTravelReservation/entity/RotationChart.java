package com.emergencyfood.PaimonTravelReservation.entity;


import lombok.Data;

import javax.persistence.Entity;

@Data
public class RotationChart {

    private Integer goodsId;

    private String imageSrc;

    private String openType;

    private String navigatorUrl;


}