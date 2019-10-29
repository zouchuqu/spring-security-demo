package com.security.demo.service.impl;

import com.security.demo.SpringSecurityDemoApplication;
import com.security.demo.SpringSecurityDemoApplicationTests;
import com.security.demo.entity.UserInfo;
import com.security.demo.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import static org.junit.Assert.*;

/**
 * @auther kklu
 * @date 2019/9/25 18:48
 * @describe
 */
@Component
@Slf4j
public class UserInfoFormServiceImplTest extends SpringSecurityDemoApplicationTests {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void create() {
        UserInfo userInfo1 = new UserInfo();
        userInfo1.setId(1L);
        userInfo1.setUsername("admin");
        userInfo1.setPassword(passwordEncoder.encode("123456"));
        UserInfo userInfoPO1 = userInfoService.create(userInfo1);
        log.info("userInfoPO1={}", userInfoPO1);

        UserInfo userInfo2 = new UserInfo();
        userInfo2.setId(2L);
        userInfo2.setUsername("user");
        userInfo2.setPassword(passwordEncoder.encode("123456"));
        UserInfo userInfoPO2 = userInfoService.create(userInfo2);
        log.info("userInfoPO2={}", userInfoPO2);
    }
}