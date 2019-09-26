package com.security.demo.controller;

import com.security.demo.entity.UserInfo;
import com.security.demo.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @auther kklu
 * @date 2019/9/25 19:12
 * @describe
 */

@RestController
@RequestMapping("/user")
@Slf4j
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/create")
    public UserInfo create(UserInfo userInfo) {
        log.info("create->{}", userInfo);
        return userInfoService.create(userInfo);
    }

    @GetMapping("/info")
    public UserInfo getUserInfoByUsername(String username) {
        return userInfoService.findByUsername(username);
    }


}
