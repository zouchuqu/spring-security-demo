package com.security.demo.service;

import com.security.demo.entity.UserInfo;

/**
 * @auther kklu
 * @date 2019/9/25 18:40
 * @describe
 */

public interface UserInfoService {

    /**
     * 创建新用户
     * @param userInfo
     * @return
     */
    UserInfo create(UserInfo userInfo);

    /**
     * 通过用户名查找用户信息
     * @param username
     * @return
     */
    UserInfo findByUsername(String username);
}
