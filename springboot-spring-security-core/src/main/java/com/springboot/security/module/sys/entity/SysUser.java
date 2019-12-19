package com.springboot.security.module.sys.entity;

import com.springboot.security.common.entity.BaseEntity;
import lombok.Data;

/**
 * @Author: chengang.wu
 * @Date: 2019-12-19 15:59
 */
@Data
public class SysUser extends BaseEntity {
    private String username;
    private String password;
}
