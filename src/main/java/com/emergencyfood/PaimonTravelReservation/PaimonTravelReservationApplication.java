package com.emergencyfood.PaimonTravelReservation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.emergencyfood.PaimonTravelReservation.mapper")
public class PaimonTravelReservationApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaimonTravelReservationApplication.class, args);
	}

}
