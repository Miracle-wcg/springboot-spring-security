package com.springboot.security.config.security.config;

import com.springboot.security.module.sys.entity.SysUser;
import com.springboot.security.module.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


/**
 * @Description:获取用户权限的service
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private SysUserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * @Description:加载用户信息&权限
     * @param: username 用户名
     * @Return: org.springframework.security.core.userdetails.UserDetails
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = userService.getUserDetailByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username : " + username);
        }
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        user.setPassword(encoder.encode(user.getPassword()));
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
