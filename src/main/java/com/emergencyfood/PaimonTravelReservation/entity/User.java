package com.emergencyfood.PaimonTravelReservation.entity;
 
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
 

@Getter
@Setter
@ToString
public class User {
 
    private Integer id;
    private String username;
    private Integer age;
    private Integer flag;
    private String password;
    private String role;
 
    public User() {
    }
 
    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}