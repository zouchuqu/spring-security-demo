package com.security.demo.repository;

import com.security.demo.entity.RoleInfo;
import com.security.demo.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @auther kklu
 * @date 2019/9/25 18:17
 * @describe
 */

@Repository
public interface RoleInfoRepository extends JpaRepository<RoleInfo, Long> {
}
