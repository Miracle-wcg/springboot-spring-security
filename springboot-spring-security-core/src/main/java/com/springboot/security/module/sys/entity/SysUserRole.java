package com.springboot.security.module.sys.entity;

import com.springboot.security.common.entity.BaseEntity;
import lombok.Data;

/**
 * @Author: chengang.wu
 * @Date: 2019-12-20 15:35
 */
@Data
public class SysUserRole extends BaseEntity {
    private Integer userId;
    private Integer roleId;
}
