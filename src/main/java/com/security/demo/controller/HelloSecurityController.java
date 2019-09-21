package com.security.demo.controller;

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
    public String hello(){
        return "Hello Spring Security!";
    }
}
