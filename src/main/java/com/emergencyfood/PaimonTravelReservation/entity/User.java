package com.emergencyfood.PaimonTravelReservation.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "sys_user")
@ApiModel(value="用户对象",description="用户对象")
public class User {

    @TableId
    private Long id ;                         // 唯一标识
    private String userName ;                // 用户名
    private String nickName ;                // 昵称
    private String password ;                // 密码
    private String status ;                  // 状态 账号状态（0正常 1停用）
    private String email ;                   // 邮箱
    private String phoneNumber ;            // 电话号码
    private String sex ;                     // 性别  用户性别（0男，1女，2未知）
    private String avatar ;                  // 用户头像
    private String userType ;                // 用户类型 （0管理员，1普通用户）
    private Long createBy ;                  // 创建人
    private Date createTime ;                // 创建时间
    private Long updateBy ;                  // 更新人
    private Date updateTime ;                // 更新时间
    private Integer delFlag ;                // 是否删除  （0代表未删除，1代表已删除）

    public User(String username,String password){
        this.userName=username;
        this.password=password;
    }
}