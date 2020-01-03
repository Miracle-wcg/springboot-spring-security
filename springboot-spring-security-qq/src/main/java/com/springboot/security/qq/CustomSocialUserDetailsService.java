package com.springboot.security.qq;

import com.springboot.security.entity.SocialUser;
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
    private SocialUserService socialUserService;

    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        SocialUser user = socialUserService.getById(userId);
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
