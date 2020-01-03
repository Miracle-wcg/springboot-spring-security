package com.springboot.security.qq;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.springboot.security.entity.SocialUser;
import com.springboot.security.security.UserPrincipal;
import com.springboot.security.service.SocialUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Service;

/**
 * @Author: chengang.wu
 * @Date: 2020-01-03 14:11
 */
@Service
public class CustomSocialUserDetailsService implements UserDetailsService, SocialUserDetailsService {
    @Autowired
    private SocialUserService userService;

    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        SocialUser user = userService.getById(userId);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with id : " + userId);
        }
        return UserPrincipal.create(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SocialUser user = userService.getOne(new LambdaQueryWrapper<SocialUser>().eq(SocialUser::getDisplayName, username));
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username : " + username);
        }
        return UserPrincipal.create(user);
    }
}
