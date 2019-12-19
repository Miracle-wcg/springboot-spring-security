package com.springboot.security.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author Miracle.wcg
 * @Date 2019-12-08 16:39
 */
@Slf4j
@Component
public class MpMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("deleteFlag", 0, metaObject);
        this.setFieldValByName("createAt", new Date(), metaObject);
        this.setFieldValByName("createBy", "SYS", metaObject);
        this.setFieldValByName("updateAt", new Date(), metaObject);
        this.setFieldValByName("updateBy", "SYS", metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateAt", new Date(), metaObject);
        this.setFieldValByName("updateBy", "SYS", metaObject);
    }
}
