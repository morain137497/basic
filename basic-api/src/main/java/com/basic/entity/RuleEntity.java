package com.basic.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
 * @user: jz
 * @date: 2021/2/23 下午6:44
 * @todo: 规则实体类
 */
@Data
@TableName("b_rule")
public class RuleEntity extends CommonEntity{
    // 0、目录，1、文件，2、操作，3、关联权限
    private Integer sign;
    // 规则名称
    private String name;
    // 前端页面路径
    private String pagePath;
    // 数据请求路径
    private String requestPath;
    // 数据请求方式
    private String requestType;
    // 目录图标
    private String icon;
    // 父级规则id
    private Long pId;
    // 排序，值越小，排序越靠前
    private Long sort;
}
