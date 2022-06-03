package com.lee.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration//설정파일을 만들기 위한 애노테이션 or Bean을 등록하기 위한 애노테이션이다.
@EnableWebSecurity//시큐리티 필터가 등록이 된다.
@EnableGlobalMethodSecurity(prePostEnabled = true)//특정 주소로 접근을 하면 권한 및 인증을 미리 체크하겠다. 3개는 셋트
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean//IOC가 된다
    public BCryptPasswordEncoder encoderPWD(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http)throws  Exception{
        http
                .csrf().disable()//csrf 토큰 비활성화
                .authorizeRequests()
                .antMatchers("/","/auth/**","/js/**","/css/**","/image/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/auth/loginForm");

    }
}
