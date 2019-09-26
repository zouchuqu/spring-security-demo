package com.security.demo.service.impl;

import com.security.demo.entity.UserInfo;
import com.security.demo.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther kklu
 * @date 2019/9/26 10:47
 * @describe
 */
@Component
@Slf4j
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("loadUserByUsername->username={}", username);
        UserInfo userInfo = userInfoService.findByUsername(username);
        if (userInfo == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        //暂时不考虑权限
        List<GrantedAuthority> authorities = new ArrayList<>();
        //如果在创建用户信息的时候没有加密，这里就需要做加密处理否则会报错
        // User userDetails = new User(userInfo.getUsername(), passwordEncoder.encode(userInfo.getPassword()), authorities);

        //已经在创建用户信息的时候做了加密处理，这里直接使用即可
        User userDetails = new User(userInfo.getUsername(), userInfo.getPassword(), authorities);

        return userDetails;
    }
}
