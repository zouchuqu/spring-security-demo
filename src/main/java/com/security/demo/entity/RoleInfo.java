package com.security.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @auther kklu
 * @date 2019/10/30 10:45
 * @describe
 */
@Entity
@Data
public class RoleInfo {
    @Id//用户id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增
    private Long id;
    //角色名
    private String name;
    //该角色所拥有的权限名称
    private String authority;

}
