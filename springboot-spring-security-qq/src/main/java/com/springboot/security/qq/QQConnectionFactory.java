package com.springboot.security.qq;

import com.springboot.security.service.QQService;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;

/**
 * 连接服务提供商的工厂类
 *
 * @Author: chengang.wu
 * @Date: 2020-01-03 11:52
 */
public class QQConnectionFactory extends OAuth2ConnectionFactory<QQService> {

    public QQConnectionFactory(String providerId, String appId, String appSecret) {
        super(providerId, new QQServiceProvider(appId, appSecret), new QQAdapter());
    }
}
