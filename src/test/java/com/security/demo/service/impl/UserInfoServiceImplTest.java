package com.security.demo.service.impl;

import com.security.demo.SpringSecurityDemoApplication;
import com.security.demo.SpringSecurityDemoApplicationTests;
import com.security.demo.entity.UserInfo;
import com.security.demo.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @auther kklu
 * @date 2019/9/25 18:48
 * @describe
 */
@Component
@Slf4j
public class UserInfoServiceImplTest extends SpringSecurityDemoApplicationTests {

    @Autowired
    private UserInfoService userInfoService;


    @Test
    public void create() {
        UserInfo userInfo1 = new UserInfo();
        userInfo1.setId(1L);
        userInfo1.setUsername("admin");
        userInfo1.setPassword("123456");
        UserInfo userInfoPO1 = userInfoService.create(userInfo1);
        log.info("userInfoPO1={}", userInfoPO1);

        UserInfo userInfo2 = new UserInfo();
        userInfo2.setId(2L);
        userInfo2.setUsername("user");
        userInfo2.setPassword("123456");
        UserInfo userInfoPO2 = userInfoService.create(userInfo2);
        log.info("userInfoPO2={}", userInfoPO2);
    }
}