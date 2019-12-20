package com.springboot.security.module.sys.entity;

import com.springboot.security.common.entity.BaseEntity;
import lombok.Data;

/**
 * @Author: chengang.wu
 * @Date: 2019-12-20 15:34
 */
@Data
public class SysRole extends BaseEntity {
    private String roleName;
    private Integer roleStatus;
}
