package com.emergencyfood.PaimonTravelReservation.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Fligts {
    private Integer fligtsId;

    private String fromCity;

    private String toCity;

    private Date depart;

    private Date Return;

    private Integer totalSeats;

    private Integer remainingSeats;

    private String classType;



}