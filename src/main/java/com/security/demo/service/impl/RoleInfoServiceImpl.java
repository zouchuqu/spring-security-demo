package com.security.demo.service.impl;

import com.security.demo.entity.RoleInfo;
import com.security.demo.repository.RoleInfoRepository;
import com.security.demo.service.RoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auther kklu
 * @date 2019/10/30 11:09
 * @describe
 */
@Service
public class RoleInfoServiceImpl implements RoleInfoService {

    @Autowired
    private RoleInfoRepository roleInfoRepository;

    /**
     * 创建角色
     *
     * @param userInfo
     * @return
     */
    @Override
    public RoleInfo create(RoleInfo userInfo) {
        return roleInfoRepository.save(userInfo);
    }

    /**
     * 通过id获取角色信息
     *
     * @param id
     * @return
     */
    @Override
    public RoleInfo findById(Long id) {
        return roleInfoRepository.findById(id).orElse(null);
    }
}
