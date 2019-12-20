package com.springboot.security.module.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.security.module.sys.entity.SysUserRole;
import com.springboot.security.module.sys.mapper.SysUserRoleMapper;
import com.springboot.security.module.sys.service.SysUserRoleService;
import org.springframework.stereotype.Service;

/**
 * @Author: chengang.wu
 * @Date: 2019-12-20 15:41
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {
}
