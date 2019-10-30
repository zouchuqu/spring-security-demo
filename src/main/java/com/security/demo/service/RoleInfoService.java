package com.security.demo.service;

import com.security.demo.entity.RoleInfo;

/**
 * @auther kklu
 * @date 2019/9/25 18:40
 * @describe
 */

public interface RoleInfoService {

    /**
     * 创建角色
     * @param userInfo
     * @return
     */
    RoleInfo create(RoleInfo userInfo);

    /**
     * 通过id获取角色信息
     * @param id
     * @return
     */
    RoleInfo findById(Long id);
}
