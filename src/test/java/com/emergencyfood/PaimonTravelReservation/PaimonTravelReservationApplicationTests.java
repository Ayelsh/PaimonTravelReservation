package com.emergencyfood.PaimonTravelReservation;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.emergencyfood.PaimonTravelReservation.entity.City;
import com.emergencyfood.PaimonTravelReservation.service.impl.cityDataServicesImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.beans.IntrospectionException;
import java.util.ArrayList;
import java.util.Calendar;

@SpringBootTest
@RunWith(SpringRunner.class)
class PaimonTravelReservationApplicationTests {

	@Autowired
	private PasswordEncoder passwordEncoder ;

	@Test
	public void testBcrypt() {
		DecodedJWT jwt = JWT.decode("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2ODA1MjU0NDcsInVzZXJpZCI6ImFkbWluIn0.ZNv5xD7-vL1h8ia8DjhA6gaZAnzLO3K50BZxC9QC21Y");
		System.out.println("你取出的："+jwt.getClaim("login_user"));
	}









}
