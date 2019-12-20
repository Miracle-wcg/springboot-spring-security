package com.springboot.security.module.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.security.module.sys.entity.SysRolePerm;
import com.springboot.security.module.sys.mapper.SysRolePermMapper;
import com.springboot.security.module.sys.service.SysRolePermService;
import org.springframework.stereotype.Service;

/**
 * @Author: chengang.wu
 * @Date: 2019-12-20 15:42
 */
@Service
public class SysRolePermServiceImpl extends ServiceImpl<SysRolePermMapper, SysRolePerm> implements SysRolePermService {
}
