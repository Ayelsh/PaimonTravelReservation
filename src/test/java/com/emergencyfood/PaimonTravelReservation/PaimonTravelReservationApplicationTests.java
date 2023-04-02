package com.emergencyfood.PaimonTravelReservation;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.emergencyfood.PaimonTravelReservation.entity.City;
import com.emergencyfood.PaimonTravelReservation.service.impl.cityDataServicesImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.beans.IntrospectionException;
import java.util.ArrayList;
import java.util.Calendar;

@SpringBootTest
@RunWith(SpringRunner.class)
class PaimonTravelReservationApplicationTests {

	@Autowired
	cityDataServicesImpl cityDataServices;

	@Test
	void contextLoads() throws IntrospectionException {


		//密钥secret
		String JWT_USER_AUTH_SECRET = "AyelshXhopeT131116QSX";

		JWTCreator.Builder builder = JWT.create();
		//添加claim
		builder.withClaim("user_id", "123456");
		builder.withClaim("user_name", "张三");
		//设置JWT令牌的过期时间为一天
		Calendar instance = Calendar.getInstance();
		instance.add(Calendar.SECOND, 1 * 86400);
		builder.withExpiresAt(instance.getTime());
		//生成JWT
		String token = builder.sign(Algorithm.HMAC256(JWT_USER_AUTH_SECRET));
		System.out.println(token);



		}





}
