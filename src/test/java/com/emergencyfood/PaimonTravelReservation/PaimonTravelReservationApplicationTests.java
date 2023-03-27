package com.emergencyfood.PaimonTravelReservation;

import com.emergencyfood.PaimonTravelReservation.entity.RotationChart;
import com.emergencyfood.PaimonTravelReservation.service.impl.rotationChartImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class PaimonTravelReservationApplicationTests {

	@Autowired
	rotationChartImpl roationChart;

	@Test
	void contextLoads() {




		if (! roationChart.getCharts().isEmpty()){
			for (int i = 0; i < roationChart.getCharts().size(); i++) {
				System.out.println( roationChart.getCharts().get(i));
			}

		}



	}

}
