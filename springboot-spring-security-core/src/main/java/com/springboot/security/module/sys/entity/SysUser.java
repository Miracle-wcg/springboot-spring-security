package com.springboot.security.module.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.springboot.security.common.entity.BaseEntity;
import lombok.Data;

import java.util.List;

/**
 * @Author: chengang.wu
 * @Date: 2019-12-19 15:59
 */
@Data
public class SysUser extends BaseEntity {
    private String username;
    private String password;
    private String email;
    @TableField(value = "is_enabled")
    private Boolean enabled;
    @TableField(exist = false)
    private List<SysRole> roles;
}
