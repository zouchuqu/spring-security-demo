package com.security.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @auther kklu
 * @date 2019/9/24 17:40
 * @describe
 */
@Configuration
@EnableWebSecurity//开启Spring Security的功能
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        //SpringSecurity 提供的一种编码器，我们也可以自己实现PasswordEncoder
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //通过内存创建用户名、密码和权限
        auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("123456")).roles("admin");
        auth.inMemoryAuthentication().withUser("user").password(passwordEncoder.encode("123456")).roles("user");
    }

}
