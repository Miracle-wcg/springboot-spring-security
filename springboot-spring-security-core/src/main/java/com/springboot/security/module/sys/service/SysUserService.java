package com.springboot.security.module.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.security.module.sys.entity.SysUser;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * @Author: chengang.wu
 * @Date: 2019-12-19 16:21
 */
public interface SysUserService extends IService<SysUser> {
    UserDetails getUserDetailsByUsername(String username);

    List<String> selectAllRoleByUserId(Integer userId);

    SysUser getUserDetailByUsername(String username);
}
