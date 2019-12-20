package com.springboot.security.config.security;

import com.springboot.security.module.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * This service will reload user information from database.
 */
@Service("databaseUserDetailService")
public class DatabaseUserDetailService implements UserDetailsService {

    @Autowired
    private SysUserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) {
        return userService.getUserDetailsByUsername(userName);
    }
}
