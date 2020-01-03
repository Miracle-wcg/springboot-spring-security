package com.springboot.security.qq;

import com.springboot.security.service.QQService;
import com.springboot.security.service.impl.QQServiceImpl;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

/**
 * 连接服务提供商
 *
 * @Author: chengang.wu
 * @Date: 2020-01-03 11:49
 */
public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQService> {
    /**
     * 获取code
     */
    private static final String QQ_URL_AUTHORIZE = "https://graph.qq.com/oauth2.0/authorize";
    /**
     * 获取access_token 也就是令牌
     */
    private static final String QQ_URL_ACCESS_TOKEN = "https://graph.qq.com/oauth2.0/token";
    private String appId;

    public QQServiceProvider(String appId, String appSecret) {
        super(new QQOAuth2Template(appId, appSecret, QQ_URL_AUTHORIZE, QQ_URL_ACCESS_TOKEN));
        this.appId = appId;
    }

    @Override
    public QQService getApi(String accessToken) {
        return new QQServiceImpl(accessToken, appId);
    }
}
