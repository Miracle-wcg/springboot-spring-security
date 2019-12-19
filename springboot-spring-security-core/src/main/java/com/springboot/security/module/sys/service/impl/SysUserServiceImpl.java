package com.springboot.security.module.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.security.module.sys.entity.SysUser;
import com.springboot.security.module.sys.mapper.SysUserMapper;
import com.springboot.security.module.sys.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * @Author: chengang.wu
 * @Date: 2019-12-19 16:21
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
}
