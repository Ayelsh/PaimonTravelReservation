package com.emergencyfood.PaimonTravelReservation.service;

import com.emergencyfood.PaimonTravelReservation.entity.City;
import com.emergencyfood.PaimonTravelReservation.entity.RotationChart;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface cityDataServices {

    ArrayList<City> getCity();
}
