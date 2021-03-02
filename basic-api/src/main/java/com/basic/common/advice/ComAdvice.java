package com.basic.common.advice;

import com.basic.common.exception.ComEx;
import com.basic.common.utils.ResUtils;
import com.basic.common.vo.ResVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @user: jz
 * @date: 2021/2/24 上午8:57
 * @todo: 自定义抛出异常信息类
 */
@ControllerAdvice
public class ComAdvice {
    @ExceptionHandler(ComEx.class)
    public ResponseEntity<ResVo> exceptionHandle(ComEx e)
    {
        return ResponseEntity.status(e.getFailedEnum().getCode()).body(ResUtils.failed(e.getFailedEnum()));
    }
}
