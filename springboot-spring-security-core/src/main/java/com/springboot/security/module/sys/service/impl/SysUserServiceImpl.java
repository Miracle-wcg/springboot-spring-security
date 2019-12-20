package com.springboot.security.module.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.security.module.sys.entity.SysUser;
import com.springboot.security.module.sys.mapper.SysUserMapper;
import com.springboot.security.module.sys.service.SysUserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: chengang.wu
 * @Date: 2019-12-19 16:21
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
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
}
