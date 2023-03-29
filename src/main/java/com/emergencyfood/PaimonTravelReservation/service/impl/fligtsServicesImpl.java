package com.emergencyfood.PaimonTravelReservation.service.impl;

import com.emergencyfood.PaimonTravelReservation.entity.Fligts;
import com.emergencyfood.PaimonTravelReservation.mapper.fligtsDataMapper;
import com.emergencyfood.PaimonTravelReservation.service.fligtsServices;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class fligtsServicesImpl implements fligtsServices {

    @Resource
    fligtsDataMapper fligtsDataMapper;


    @Override
    public List<Fligts> getFligts(String FromCity, String ToCity, Date DepartTime, Date ReturnTime, int PassengerNum, String ClassType) {
        return fligtsDataMapper.selectFligts(FromCity,ToCity,DepartTime,ReturnTime,PassengerNum,ClassType);
    }
}
