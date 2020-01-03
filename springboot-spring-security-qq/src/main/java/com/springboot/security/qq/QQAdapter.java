package com.springboot.security.qq;

import com.springboot.security.service.QQService;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

/**
 * 适配spring Social默认的返回信息
 *
 * @Author: chengang.wu
 * @Date: 2020-01-03 11:53
 */
public class QQAdapter implements ApiAdapter<QQService> {
    @Override
    public boolean test(QQService api) {
        return false;
    }

    @Override
    public void setConnectionValues(QQService api, ConnectionValues values) {

    }

    @Override
    public UserProfile fetchUserProfile(QQService api) {
        return null;
    }

    @Override
    public void updateStatus(QQService api, String message) {

    }
}
