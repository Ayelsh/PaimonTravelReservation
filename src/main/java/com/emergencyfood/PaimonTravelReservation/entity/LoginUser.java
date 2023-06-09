package com.emergencyfood.PaimonTravelReservation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

// 用来封装数据库查询出来的用户数据
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUser implements UserDetails {

    private User user ;
   
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {          // 账号是否没有过期
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {           // 账号是否没有被锁定
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {      // 账号的凭证是否没有过期
        return true;
    }

    @Override
    public boolean isEnabled() {                    // 账号是否可用
        return true;
    }
}