package com.springboot.security.module.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.security.module.sys.entity.SysRole;
import com.springboot.security.module.sys.mapper.SysRoleMapper;
import com.springboot.security.module.sys.service.SysRoleService;
import org.springframework.stereotype.Service;

/**
 * @Author: chengang.wu
 * @Date: 2019-12-20 15:39
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
}
