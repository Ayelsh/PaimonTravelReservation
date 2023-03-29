package com.emergencyfood.PaimonTravelReservation.service;

import com.emergencyfood.PaimonTravelReservation.entity.Fligts;
import com.emergencyfood.PaimonTravelReservation.mapper.fligtsDataMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public interface fligtsServices {

    List<Fligts> getFligts(String FromCity , String ToCity ,
                           Date DepartTime ,  Date ReturnTime ,
                           int PassengerNum, String ClassType);

}
