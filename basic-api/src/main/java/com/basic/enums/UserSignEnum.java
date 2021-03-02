package com.basic.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @user: jz
 * @date: 2021/2/25 上午10:17
 * @todo:
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum UserSignEnum {

    SUPER_ADMIN(0, "超级管理员"),
    ADMIN(1, "管理员"),
    USER(2, "用户")

    ;

    private Integer value;
    private String remarks;
}
