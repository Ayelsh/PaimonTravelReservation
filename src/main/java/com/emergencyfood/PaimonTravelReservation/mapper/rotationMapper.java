package com.emergencyfood.PaimonTravelReservation.mapper;

import com.emergencyfood.PaimonTravelReservation.entity.RotationChart;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface rotationMapper {

    @Select("select * from rotation_chart")
    @ResultType(RotationChart.class)
    @Results(value={
            @Result(property="goodsId", column="goods_id"),
            @Result(property="imageSrc", column="image_src"),
            @Result(property="openType", column="open_type"),
            @Result(property="navigatorUrl", column="navigator_url")
    })
    ArrayList<RotationChart> selectAll();

    @Select("select image_src from rotation_chart")
    ArrayList<String> selectAllSrc();
}
