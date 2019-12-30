package com.springboot.security.module.sys.entity;

import com.springboot.security.common.entity.BaseEntity;
import lombok.Data;

/**
 * @Author: chengang.wu
 * @Date: 2019-12-20 15:36
 */
@Data
public class SysRolePerm extends BaseEntity {
    private Integer roleId;
    private Integer permId;
}
