package com.emergencyfood.PaimonTravelReservation.mapper;

import com.emergencyfood.PaimonTravelReservation.entity.Fligts;
import com.emergencyfood.PaimonTravelReservation.entity.RotationChart;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import java.util.Date;

@Mapper
public interface fligtsDataMapper {


    /**
     * @Author Ayrlsh
     * @param FromCity
     * @param ToCity
     * @param DepartTime
     * @param ReturnTime
     * @param PassengerNum
     * @param ClassType
     * @return
     */
    @Select("select * from fligts where From_city = #{FromCity} and To_city = #{ToCity} and " +
            "DepartTime = #{DepartTime} and ReturnTime = #{ReturnTime} and Class_type = #{ClassType} " +
            "and Remaining_seats > #{PassengerNum}" )
    @ResultType(Fligts.class)
    @Results(value={
            @Result(property="fromCity", column="From_city"),
            @Result(property="toCity", column="To_city"),
            @Result(property="depart", column="Depart"),
            @Result(property="Return", column="ReturnTime"),
            @Result(property="classType", column="Class_type"),
            @Result(property="remainingSeats", column="Remaining_seats"),
            @Result(property="totalSeats", column="Total_seats"),
            @Result(property="fligtsId", column="Fligts_id")
    })//返回结果和原数据库的数据映射
    ArrayList<Fligts> selectFligts(@Param("FromCity") String FromCity , @Param("ToCity")String ToCity ,
                                   @Param("DepartTime") Date DepartTime , @Param("ReturnTime") Date ReturnTime ,
                                   @Param("PassengerNum")int PassengerNum, @Param("ClassType")String ClassType);

}
