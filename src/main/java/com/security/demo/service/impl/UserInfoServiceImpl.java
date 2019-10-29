package com.security.demo.service.impl;

import com.security.demo.entity.UserInfo;
import com.security.demo.repository.UserInfoRepository;
import com.security.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @auther kklu
 * @date 2019/9/25 18:42
 * @describe
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 创建新用户
     *
     * @param userInfo
     * @return
     */
    @Override
    public UserInfo create(UserInfo userInfo) {
        //对密码加密
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        return userInfoRepository.save(userInfo);
    }

    /**
     * 通过用户名查找用户信息
     *
     * @param username
     * @return
     */
    @Override
    public UserInfo findByUsername(String username) {
        return userInfoRepository.findByUsername(username);
    }
}
