package com.basic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.basic.entity.UserEntity;
import com.basic.entity.UserRoleEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleMapper extends BaseMapper<UserRoleEntity> {
}
