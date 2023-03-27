package com.emergencyfood.PaimonTravelReservation.service.impl;

import com.emergencyfood.PaimonTravelReservation.entity.RotationChart;
import com.emergencyfood.PaimonTravelReservation.mapper.rotationMapper;
import com.emergencyfood.PaimonTravelReservation.service.rotationChart;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class rotationChartImpl implements rotationChart {

    @Resource
    rotationMapper rCMapper;

    @Override
    public ArrayList<RotationChart> getCharts() {

        return rCMapper.selectAll();

    }



}
