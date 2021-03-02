package com.basic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.basic.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<UserEntity> {
}
