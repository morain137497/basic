package com.basic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.basic.common.enums.FailedEnum;
import com.basic.common.exception.ComEx;
import com.basic.common.utils.ResUtils;
import com.basic.entity.RoleEntity;
import com.basic.entity.RoleRuleEntity;
import com.basic.entity.UserEntity;
import com.basic.entity.UserRoleEntity;
import com.basic.mapper.RoleMapper;
import com.basic.mapper.RoleRuleMapper;
import com.basic.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @user: jz
 * @date: 2021/2/23 下午7:04
 * @todo:
 */
@Service
public class RoleServiceImpl extends CommonServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleRuleMapper roleRuleMapper;

    @Override
    public void create(RoleEntity roleEntity) {
        if(roleMapper.insert(roleEntity) != 1)
            throw new ComEx(FailedEnum.SYSTEM_FAILED);
    }

    @Override
    public void delete(Long id) {
        dataWhetherExist(id, roleMapper);
        if(roleMapper.deleteById(id) != 1)
            throw new ComEx(FailedEnum.SYSTEM_FAILED);
    }

    @Override
    public void update(RoleEntity roleEntity) {
        dataWhetherExist(roleEntity.getId(), roleMapper);
        ResUtils.throwsEx(roleMapper.updateById(roleEntity));
    }

    @Override
    public void updateStatus(Long id, Integer status) {
        dataWhetherExist(id, roleMapper);
        ResUtils.throwsEx(roleMapper.updateById(new RoleEntity(id, status)));
    }

    @Override
    public void adminRole(Long id, List<Long> ruleIdList) {
        dataWhetherExist(id, roleMapper);
        int delete = roleRuleMapper.delete(new QueryWrapper<RoleRuleEntity>().lambda().eq(RoleRuleEntity::getRoleId, id));
        if(delete < 0)
            throw new ComEx(FailedEnum.SYSTEM_FAILED);
        if(!CollectionUtils.isEmpty(ruleIdList))
            ruleIdList.forEach(item -> roleRuleMapper.insert(new RoleRuleEntity(id, item)));
    }
}
