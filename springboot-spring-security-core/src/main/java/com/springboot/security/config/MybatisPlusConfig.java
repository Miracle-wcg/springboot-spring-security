package com.springboot.security.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan("com.springboot.security.module.*.mapper")
@EnableTransactionManagement
public class MybatisPlusConfig {

    /**
     * 分页插件
     *
     * @return com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
     * @author fxbin
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
