package com.basic.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
 * @user: jz
 * @date: 2021/2/23 下午6:44
 * @todo: 角色实体类
 */
@Data
@TableName("b_role")
public class RoleEntity extends CommonEntity{
    // 角色名
    private String name;
    // 角色备注
    private String remarks;
}
