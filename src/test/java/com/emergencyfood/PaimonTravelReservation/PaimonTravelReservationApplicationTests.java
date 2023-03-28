package com.emergencyfood.PaimonTravelReservation;

import com.emergencyfood.PaimonTravelReservation.commons.JudgeObjIsNullUtil;
import com.emergencyfood.PaimonTravelReservation.entity.City;
import com.emergencyfood.PaimonTravelReservation.service.impl.cityDataServicesImpl;
import com.emergencyfood.PaimonTravelReservation.service.impl.rotationChartServicesImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.beans.IntrospectionException;
import java.util.ArrayList;

@SpringBootTest
@RunWith(SpringRunner.class)
class PaimonTravelReservationApplicationTests {

	@Autowired
	cityDataServicesImpl cityDataServices;

	@Test
	void contextLoads() throws IntrospectionException {


		ArrayList<City> a = cityDataServices.getCity();

		System.out.println(a);
		System.out.println(cityDataServices.getCity().toString().equals("[]") ? true : false);
		System.out.println(a.toString());



		}





}
