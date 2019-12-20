package com.springboot.security.module.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.security.module.sys.entity.SysPerm;
import com.springboot.security.module.sys.mapper.SysPermMapper;
import com.springboot.security.module.sys.service.SysPermService;
import org.springframework.stereotype.Service;

/**
 * @Author: chengang.wu
 * @Date: 2019-12-20 15:40
 */
@Service
public class SysPermServiceImpl extends ServiceImpl<SysPermMapper, SysPerm> implements SysPermService {
}
