package com.springboot.security;

import com.springboot.security.module.sys.entity.SysUser;
import com.springboot.security.module.sys.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: chengang.wu
 * @Date: 2019-12-19 16:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserServiceTest {
    @Autowired
    private SysUserService sysUserService;

    @Test
    public void save() {
        SysUser user = new SysUser();
        user.setUsername("test");
        user.setPassword("123456");
        sysUserService.save(user);
    }
}
