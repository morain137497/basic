package com.basic.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum FailedEnum {

    SYSTEM_FAILED(500, "系统错误"),
    USERNAME_REPEAT(400, "用户名重复"),
    NO_UPDATE_DATA(400, "没有修改任何数据"),
    DATA_NOT_EXIST(404, "数据不存在")

    ;
    private Integer code;
    private String message;
}
