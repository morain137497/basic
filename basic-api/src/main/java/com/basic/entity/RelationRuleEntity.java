package com.basic.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @user: jz
 * @date: 2021/2/23 下午6:56
 * @todo: 关联规则实体类
 */
@Data
@TableName("b_relation_rule")
public class RelationRuleEntity {
    // 规则id
    private Long ruleId;
    // 关联规则id
    private Long relationRuleId;
}
