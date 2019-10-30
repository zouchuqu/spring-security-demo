package com.security.demo.service.impl;

import com.security.demo.SpringSecurityDemoApplicationTests;
import com.security.demo.entity.RoleInfo;
import com.security.demo.service.RoleInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @auther kklu
 * @date 2019/10/30 11:12
 * @describe
 */
@Slf4j
public class RoleInfoServiceImplTest extends SpringSecurityDemoApplicationTests {

    @Autowired
    private RoleInfoService roleInfoService;

    @Test
    public void create() {
        RoleInfo roleInfo1 = new RoleInfo();
        roleInfo1.setId(1L);
        roleInfo1.setName("管理员");
        roleInfo1.setAuthority("ADMIN");
        roleInfoService.create(roleInfo1);

        RoleInfo roleInfo2 = new RoleInfo();
        roleInfo2.setId(2L);
        roleInfo2.setName("普通用户");
        roleInfo2.setAuthority("USER");
        roleInfoService.create(roleInfo2);

    }

    @Test
    public void findById() {
        RoleInfo result = roleInfoService.findById(1L);
        log.info("result:{}", result);
    }
}