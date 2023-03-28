package com.emergencyfood.PaimonTravelReservation.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value="城市对象",description="城市对象")
public class City {
    private String name;

    private String imageSrc;

    private String openType;

    private String navigatorUrl;


}