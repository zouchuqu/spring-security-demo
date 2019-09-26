package com.security.demo.repository;

import com.security.demo.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @auther kklu
 * @date 2019/9/25 18:17
 * @describe
 */

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    /**
     * 通过用户名获取用户信息
     * @param username
     * @return
     */
    UserInfo findByUsername(String username);
}
