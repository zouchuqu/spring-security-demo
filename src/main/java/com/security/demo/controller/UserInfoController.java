package com.security.demo.controller;

import com.security.demo.entity.UserInfo;
import com.security.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther kklu
 * @date 2019/9/25 19:12
 * @describe
 */

@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/create")
    public UserInfo create(@RequestBody UserInfo userInfo){
        return userInfoService.create(userInfo);
    }
}
