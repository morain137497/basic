package com.basic.common.exception;

import com.basic.common.enums.FailedEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @user: jz
 * @date: 2021/2/24 上午8:55
 * @todo: 自定义异常类
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ComEx extends RuntimeException{
    private FailedEnum failedEnum;
}
