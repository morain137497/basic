package com.basic.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @user: jz
 * @date: 2021/2/23 下午6:45
 * @todo: 公共实体类
 */
@Data
@NoArgsConstructor
public class CommonEntity implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Integer status;
    private Integer isDel;
    private Date cTime;
    private Date uTime;

    public CommonEntity(Long id, Integer status) {
        this.id = id;
        this.status = status;
    }
}
