package com.springboot.security.config.security;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.springboot.security.module.sys.entity.SysUser;
import com.springboot.security.module.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author Miracle.wcg
 * @Date 2019-12-26 00:11
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private SysUserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        // Let people login with either username
        SysUser user = userService.getOne(new LambdaQueryWrapper<SysUser>().eq(SysUser::getUsername, username));
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username : " + username);
        }
        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        SysUser user = userService.getById(id);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with id : " + id);
        }
        return UserPrincipal.create(user);
    }
}
