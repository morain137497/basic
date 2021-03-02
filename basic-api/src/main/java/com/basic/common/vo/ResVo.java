package com.basic.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @user: jz
 * @date: 2021/2/23 下午7:07
 * @todo: 通用返回数据vo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResVo<T> {
    private Integer code;
    private String message;
    private T data;
}
