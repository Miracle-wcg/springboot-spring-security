package com.springboot.security;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.springboot.security.module.sys.entity.SysRole;
import com.springboot.security.module.sys.entity.SysUser;
import com.springboot.security.module.sys.entity.SysUserRole;
import com.springboot.security.module.sys.service.SysRoleService;
import com.springboot.security.module.sys.service.SysUserRoleService;
import com.springboot.security.module.sys.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: chengang.wu
 * @Date: 2019-12-19 16:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserServiceTest {
    @Autowired
    private SysUserService userService;
    @Autowired
    private SysRoleService roleService;
    @Autowired
    private SysUserRoleService userRoleService;

    @Test
    public void saveSysUser() {
        SysUser user = new SysUser();
        user.setUsername("test");
        user.setPassword("123456");
        userService.save(user);
    }

    @Test
    public void saveSysRole() {
        SysRole role = new SysRole();
        role.setRoleName("admin");
        roleService.save(role);
    }

    @Test
    public void saveSysUserRole() {
        SysUserRole userRole = new SysUserRole();
        userRole.setUserId(1);
        userRole.setRoleId(1);
        userRoleService.save(userRole);
    }

    @Test
    public void selectAllRoleByUserId() {
//        List<String> list = userService.selectAllRoleByUserId(1);
//        SysUser admin = userService.getOne(new LambdaQueryWrapper<SysUser>().eq(SysUser::getUsername, "admin"));
//        SysUser admin1 = userService.getUserDetailByUsername("admin");
        List<SysUser> list = userService.list();
        System.out.println(111);
    }

    @Test
    public void saveUser() {
        SysUser user = new SysUser();
        user.setUsername("bbb");
        user.setPassword("123123");
        user.setEnabled(true);
        userService.save(user);
    }
}
