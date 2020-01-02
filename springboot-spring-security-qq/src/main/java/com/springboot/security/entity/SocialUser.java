package com.springboot.security.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author: chengang.wu
 * @Date: 2020-01-02 17:32
 */
@Data
@TableName(value = "social_user")
public class SocialUser {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer providerId;
    private Integer providerUserId;
    private Integer rank;
    private String displayName;
    private String profileUrl;
    private String imageUrl;
    private String accessToken;
    private String secret;
    private String refreshToken;
    private Integer expireTime;
}
