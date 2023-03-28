package com.emergencyfood.PaimonTravelReservation.service.impl;

import com.emergencyfood.PaimonTravelReservation.entity.City;
import com.emergencyfood.PaimonTravelReservation.mapper.cityDataMapper;
import com.emergencyfood.PaimonTravelReservation.service.cityDataServices;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class cityDataServicesImpl implements cityDataServices {

    @Resource
    cityDataMapper cityDataMapper;

    @Override
    public ArrayList<City> getCity() {
        return cityDataMapper.selectAll();
    }
}
