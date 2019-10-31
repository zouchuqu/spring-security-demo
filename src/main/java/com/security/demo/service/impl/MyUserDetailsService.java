package com.security.demo.service.impl;

import com.security.demo.entity.RoleInfo;
import com.security.demo.entity.UserInfo;
import com.security.demo.service.RoleInfoService;
import com.security.demo.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
    private RoleInfoService roleInfoService;

    /**
     * 在这个方法中实现用户身份认证和授权
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("loadUserByUsername->username={}", username);
        UserInfo userInfo = userInfoService.findByUsername(username);
        if (userInfo == null) {
            log.info("loadUserByUsername->用户不存在={}", "用户不存在");
            throw new UsernameNotFoundException("用户不存在");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();

        RoleInfo roleInfo = roleInfoService.findById(userInfo.getRid());
        log.info("roleInfo={}",roleInfo);
        if (roleInfo != null) {
            // 用户可以访问的资源名称（或者说用户所拥有的权限） 注意：必须"ROLE_"开头
            authorities.add(new SimpleGrantedAuthority("ROLE_" + roleInfo.getAuthority()));
        }
        //注意要在创建用户信息的时候密码需要加密
        User userDetails = new User(userInfo.getUsername(), userInfo.getPassword(), authorities);

        return userDetails;
    }
}
