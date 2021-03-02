package com.basic.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @user: jz
 * @date: 2021/2/23 下午6:44
 * @todo: 用户角色实体类
 */
@Data
@TableName("b_user_role")
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleEntity{
    // 用户id
    private Long userId;
    // 角色id
    private Long roleId;
}
