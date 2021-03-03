package com.basic.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.basic.common.enums.FailedEnum;
import com.basic.common.exception.ComEx;
import org.springframework.util.StringUtils;

/**
 * @user: jz
 * @date: 2021/3/3 下午8:57
 * @todo:
 */
public class CommonServiceImpl {
    /**
     * 判断数据是否存在
     * @param id
     * @return
     */
    public void dataWhetherExist(Long id, BaseMapper mapper)
    {
        if(StringUtils.isEmpty(mapper.selectById(id)))
            throw new ComEx(FailedEnum.DATA_NOT_EXIST);
    }
}
