package com.security.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * @auther kklu
 * @date 2019/9/25 17:46
 * @describe
 */
@Entity
@Data
public class UserInfo {

    @Id//用户id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增
    private Long id;
    //用户名
    private String username;
    //用户密码
    private String password;

}
