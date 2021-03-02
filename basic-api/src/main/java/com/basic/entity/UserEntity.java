package com.basic.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @user: jz
 * @date: 2021/2/23 下午6:44
 * @todo: 用户实体类
 */
@Data
@TableName("b_user")
@NoArgsConstructor
public class UserEntity extends CommonEntity{
    // 0、超级管理员，1、普通管理员，2、用户
    private Integer sign;
    // 用户名
    private String username;
    // 手机号
    private String mobileNumber;
    // 密码
    private String password;

    public UserEntity(Long id, Integer status) {
        super(id, status);
    }
}
