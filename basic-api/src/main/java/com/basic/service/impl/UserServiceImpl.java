package com.basic.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.basic.common.enums.FailedEnum;
import com.basic.common.exception.ComEx;
import com.basic.common.utils.ResUtils;
import com.basic.entity.UserEntity;
import com.basic.entity.UserRoleEntity;
import com.basic.mapper.UserMapper;
import com.basic.mapper.UserRoleMapper;
import com.basic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @user: jz
 * @date: 2021/2/23 下午7:04
 * @todo:
 */
@Service
public class UserServiceImpl extends CommonServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public void create(UserEntity userEntity) {
        if(paramWhetherRepeat(UserEntity::getUsername, userEntity.getUsername(), null))
            throw new ComEx(FailedEnum.USERNAME_REPEAT);
        if(userMapper.insert(userEntity) != 1)
            throw new ComEx(FailedEnum.SYSTEM_FAILED);
    }

    @Override
    public void delete(Long id) {
        dataWhetherExist(id, userMapper);
        if(userMapper.deleteById(id) != 1)
            throw new ComEx(FailedEnum.SYSTEM_FAILED);
    }

    @Override
    public void update(UserEntity userEntity) {
        dataWhetherExist(userEntity.getId(), userMapper);
        if(paramWhetherRepeat(UserEntity::getUsername, userEntity.getUsername(), userEntity.getId()))
            throw new ComEx(FailedEnum.USERNAME_REPEAT);
        ResUtils.throwsEx(userMapper.updateById(userEntity));
    }

    @Override
    public void updateStatus(Long id, Integer status) {
        dataWhetherExist(id, userMapper);
        ResUtils.throwsEx(userMapper.updateById(new UserEntity(id, status)));
    }

    @Override
    public Page<UserEntity> list(String username, Integer page, Integer pageSize, List<Integer> signList) {
        LambdaQueryWrapper<UserEntity> lambda = new QueryWrapper<UserEntity>().lambda();
        if(!StringUtils.isEmpty(username))
            lambda.like(UserEntity::getUsername, username);
        lambda.orderByAsc(UserEntity::getSign);
        return userMapper.selectPage(new Page<>(page, pageSize), lambda);
    }

    @Override
    public void adminRole(Long id, List<Long> roleIdList) {
        dataWhetherExist(id, userMapper);
        int delete = userRoleMapper.delete(new QueryWrapper<UserRoleEntity>().lambda().eq(UserRoleEntity::getUserId, id));
        if(delete < 0)
            throw new ComEx(FailedEnum.SYSTEM_FAILED);
        if(!CollectionUtils.isEmpty(roleIdList))
            roleIdList.forEach(item -> userRoleMapper.insert(new UserRoleEntity(id, item)));
    }


    /**
     * 判断参数是否重复
     * @param param
     * @param value
     * @return
     */
    private boolean paramWhetherRepeat(SFunction<UserEntity, ?> param, Object value, Long id) {
        LambdaQueryWrapper<UserEntity> lambda = new QueryWrapper<UserEntity>().lambda();
        lambda.select(UserEntity::getId).eq(param, value);
        if(!StringUtils.isEmpty(id))
            lambda.ne(UserEntity::getId, id);
        if(StringUtils.isEmpty(userMapper.selectOne(lambda)))
            return false;
        else
            return true;
    }
}
