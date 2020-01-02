package com.springboot.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.security.entity.SocialUser;
import com.springboot.security.mapper.SocialUserMapper;
import com.springboot.security.service.SocialUserService;
import org.springframework.stereotype.Service;

/**
 * @Author: chengang.wu
 * @Date: 2020-01-02 17:37
 */
@Service
public class SocialUserServiceImpl extends ServiceImpl<SocialUserMapper, SocialUser> implements SocialUserService {
}
