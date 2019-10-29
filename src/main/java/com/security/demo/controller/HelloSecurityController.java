package com.security.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther kklu
 * @date 2019/9/21 12:21
 * @describe
 */
@RestController
@RequestMapping("/hello")
public class HelloSecurityController {

    @GetMapping
    public String hello() {
        return "Hello Spring Security!";
    }

//
//    @GetMapping("/user")
//    @PreAuthorize("hasAnyRole('admin')")
//    public String user() {
//        return "Hello,user";
//    }
//
//    @GetMapping("/admin")
//    @PreAuthorize("hasAnyRole('admin','user')")
//    public String admin() {
//        return "Hello,admin";
//    }
}
