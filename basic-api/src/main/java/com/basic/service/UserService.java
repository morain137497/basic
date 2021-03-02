package com.basic.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.basic.entity.UserEntity;

import java.util.List;

/**
 * @user: jz
 * @date: 2021/2/23 下午7:04
 * @todo:
 */
public interface UserService {
    void create(UserEntity userEntity);

    void delete(Long id);

    void update(UserEntity userEntity);

    void updateStatus(Long id, Integer status);

    Page<UserEntity> list(String username, Integer page, Integer pageSize, List<Integer> signList);

    void adminRole(Long id, List<Long> roleIdList);
}
