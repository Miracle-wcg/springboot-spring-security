package com.springboot.security.module.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.security.module.sys.entity.SysRole;
import com.springboot.security.module.sys.entity.SysUser;
import com.springboot.security.module.sys.entity.SysUserRole;
import com.springboot.security.module.sys.mapper.SysUserMapper;
import com.springboot.security.module.sys.service.SysRoleService;
import com.springboot.security.module.sys.service.SysUserRoleService;
import com.springboot.security.module.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author: chengang.wu
 * @Date: 2019-12-19 16:21
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Autowired
    private SysUserRoleService userRoleService;
    @Autowired
    private SysRoleService roleService;

    @Override
    public UserDetails getUserDetailsByUsername(String username) {
        SysUser sysUser = getOne(new LambdaQueryWrapper<SysUser>().eq(SysUser::getUsername, username));
        if (sysUser == null) {
            throw new UsernameNotFoundException("Username " + username + "is not found");
        }
        List<String> roleList = baseMapper.selectAllRoleByUserId(sysUser.getId());
        List<SimpleGrantedAuthority> authorities = roleList.stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
        return new User(username, sysUser.getPassword(), authorities);
    }

    @Override
    public List<String> selectAllRoleByUserId(Integer userId) {
        return baseMapper.selectAllRoleByUserId(userId);
    }

    @Override
    public SysUser getUserDetailByUsername(String username) {
        SysUser user = getOne(new LambdaQueryWrapper<SysUser>().eq(SysUser::getUsername, username));
        if (user != null) {
            Set<Integer> roleIds = userRoleService.list(new LambdaQueryWrapper<SysUserRole>().eq(SysUserRole::getUserId, user.getId()).eq(SysUserRole::getDeleteFlag, false))
                    .stream().map(sysUserRole -> sysUserRole.getRoleId()).collect(Collectors.toSet());
            if (CollectionUtils.isNotEmpty(roleIds)) {
                List<SysRole> roleList = roleService.list(new LambdaQueryWrapper<SysRole>().eq(SysRole::getDeleteFlag, 0).in(SysRole::getId, roleIds));
                if (CollectionUtils.isNotEmpty(roleList)) {
                    user.setRoles(roleList);
                }
            }
            return user;
        }
        return null;
    }
}
