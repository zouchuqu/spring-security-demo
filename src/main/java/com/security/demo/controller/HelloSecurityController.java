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

    /**
     * 在这里例子中 用户 admin 和 user 都能访问这个接口
     * @return
     */
    @GetMapping("/helloUser")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")//访问这个接口需要有 admin或者user 的权限的用户才能访问
    public String user() {

        return "Hello,user";
    }

    /**
     * 在这里例子中 用户 user 是不能访问这个接口的，会报权限不足异常
     * @return
     */
    @GetMapping("/helloAdmin")
    @PreAuthorize("hasAnyRole('ADMIN')")//访问这个接口需要有 admin 的权限的用户才能访问
    public String admin() {
        return "Hello,admin";
    }
}
