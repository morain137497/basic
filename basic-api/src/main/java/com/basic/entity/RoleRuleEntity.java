package com.basic.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @user: jz
 * @date: 2021/2/23 下午6:44
 * @todo: 角色规则实体类
 */
@Data
@TableName("b_role_rule")
@AllArgsConstructor
@NoArgsConstructor
public class RoleRuleEntity {
    // 规则id
    private Long ruleId;
    // 角色id
    private Long roleId;
}
