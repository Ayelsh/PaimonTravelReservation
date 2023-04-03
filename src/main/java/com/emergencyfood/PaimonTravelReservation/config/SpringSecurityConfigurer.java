package com.emergencyfood.PaimonTravelReservation.config;

import com.emergencyfood.PaimonTravelReservation.Interceptor.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authorization.method.AuthorizationManagerAfterMethodInterceptor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SpringSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder() ;
    }

    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
    // 配置Spring Security的拦截规则
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()                                                               // 关闭csrf
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)     // 指定session的创建策略，不使用session
                .and()                                                                          // 再次获取到HttpSecurity对象
                .authorizeRequests()                                                            // 进行认证请求的配置
                .antMatchers("/login").anonymous()                                         // 对于登录接口，允许匿名访问
                .antMatchers("/doc.html").anonymous()
                .antMatchers("/swagger-resources/**").anonymous()
                .antMatchers("/webjars/**").anonymous()
                .antMatchers("/v2/**").anonymous()
                .antMatchers("/favicon.ico").anonymous()
                .antMatchers("/swagger-ui.html/**").anonymous()
                .anyRequest().authenticated();                                                  // 除了上面的请求以外所有的请求全部需要认证
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}