package com.basic.service;

import com.basic.entity.RoleEntity;

import java.util.List;

/**
 * @user: jz
 * @date: 2021/2/23 下午7:04
 * @todo:
 */
public interface RoleService {
    void create(RoleEntity roleEntity);

    void delete(Long id);

    void update(RoleEntity roleEntity);

    void updateStatus(Long id, Integer status);

    void adminRole(Long id, List<Long> ruleIdList);
}
