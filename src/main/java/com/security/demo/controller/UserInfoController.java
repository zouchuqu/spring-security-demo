package com.security.demo.controller;

import com.security.demo.entity.UserInfo;
import com.security.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

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
    public UserInfo create(@RequestBody UserInfo userInfo) {
        return userInfoService.create(userInfo);
    }

    @GetMapping("/loginInfo")
    public UserInfo loginInfo(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserInfo userInfo = new UserInfo();
        if("anonymousUser".equals(principal)) {
//            model.addAttribute("name","anonymous");
            userInfo.setUsername("anonymous");
        }else {
            userInfo = (UserInfo)principal;
//            model.addAttribute("name",user.getUsername());
        }
        return userInfo;
    }
     @GetMapping("/userInfo")
    public UserInfo userInfo(String username){
        return userInfoService.findByUsername(username);
    }

}
