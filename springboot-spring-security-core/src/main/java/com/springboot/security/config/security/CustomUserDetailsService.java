package com.springboot.security.config.security;

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
    public UserDetails loadUserByUsername(String usernameOrEmail)
            throws UsernameNotFoundException {
        // Let people login with either username or email
//        User user = userService.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
//                .orElseThrow(() ->
//                        new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail)
//                );
//
//        return UserPrincipal.create(user);
        return null;
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
//        User user = userRepository.findById(id).orElseThrow(
//                () -> new ResourceNotFoundException("User", "id", id)
//        );
//
//        return UserPrincipal.create(user);
        return null;
    }
}
