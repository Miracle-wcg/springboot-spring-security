package com.springboot.security.module.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.security.module.sys.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: chengang.wu
 * @Date: 2019-12-19 16:18
 */
public interface SysUserMapper extends BaseMapper<SysUser> {
    List<String> selectAllRoleByUserId(@Param("userId") Integer userId);
}
