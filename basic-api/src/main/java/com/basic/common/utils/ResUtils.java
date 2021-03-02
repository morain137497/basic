package com.basic.common.utils;

import com.basic.common.enums.FailedEnum;
import com.basic.common.exception.ComEx;
import com.basic.common.vo.ResVo;
import org.springframework.http.HttpStatus;

/**
 * @user: jz
 * @date: 2021/2/23 下午7:08
 * @todo: 通用返回工具类
 */
public class ResUtils {

    public static <T> ResVo<T> success()
    {
        return new ResVo<T>(HttpStatus.OK.value(), "success", null);
    }

    public static <T> ResVo<T> success(T data)
    {
        return new ResVo<T>(HttpStatus.OK.value(), "success", data);
    }

    public static <T> ResVo<T> failed(FailedEnum failedEnum)
    {
        return new ResVo<T>(failedEnum.getCode(), failedEnum.getMessage(), null);
    }

    public static void throwsEx(Integer res)
    {
        if(res == 0)
            throw new ComEx(FailedEnum.NO_UPDATE_DATA);
        if(res < 0)
            throw new ComEx(FailedEnum.NO_UPDATE_DATA);
    }
}
