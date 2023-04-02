package com.emergencyfood.PaimonTravelReservation.mapper;

import com.emergencyfood.PaimonTravelReservation.entity.City;
import com.emergencyfood.PaimonTravelReservation.entity.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

public interface userDataMapper {
    @Select("select * from user where username = #{username}")
    @ResultType(User.class)
    @Results(value={
            @Result(property="id", column="id"),
            @Result(property="username", column="username"),
            @Result(property="password", column="password"),
            @Result(property="age", column="age"),
            @Result(property="role", column="role"),
            @Result(property="flag", column="flag")


    })
    User selectByUsername(String username);
}
