package com.emergencyfood.PaimonTravelReservation.mapper;

import com.emergencyfood.PaimonTravelReservation.entity.City;
import com.emergencyfood.PaimonTravelReservation.entity.RotationChart;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface cityDataMapper {

    @Select("select * from city_data")
    @ResultType(RotationChart.class)
    @Results(value={
            @Result(property="name", column="name"),
            @Result(property="imageSrc", column="image_src"),
            @Result(property="openType", column="open_type"),
            @Result(property="navigatorUrl", column="navigator_url")
    })
    ArrayList<City> selectAll();


}
