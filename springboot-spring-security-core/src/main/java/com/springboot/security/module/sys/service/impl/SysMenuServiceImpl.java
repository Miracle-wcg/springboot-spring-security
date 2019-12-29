package com.springboot.security.module.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.security.module.sys.entity.SysMenu;
import com.springboot.security.module.sys.mapper.SysMenuMapper;
import com.springboot.security.module.sys.service.SysMenuService;
import org.springframework.stereotype.Service;

/**
 * @Author Miracle.wcg
 * @Date 2019/12/28 10:42 下午
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {
}
