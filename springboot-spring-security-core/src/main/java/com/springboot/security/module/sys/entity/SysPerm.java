package com.springboot.security.module.sys.entity;

import com.springboot.security.common.entity.BaseEntity;
import lombok.Data;

/**
 * @Author: chengang.wu
 * @Date: 2019-12-20 15:35
 */
@Data
public class SysPerm extends BaseEntity {
    private String perms_name;
    private String perms_path;
    private String perm;
}
