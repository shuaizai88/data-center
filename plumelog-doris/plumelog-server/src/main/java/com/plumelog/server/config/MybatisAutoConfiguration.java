package com.plumelog.server.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.JoinInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.KeyGeneratorInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * sm2加解密
 * @author wanglei
 */
@Configuration
@EnableTransactionManagement
public class MybatisAutoConfiguration {

    public MybatisAutoConfiguration() {
    }

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        interceptor.addInnerInterceptor(new JoinInterceptor());
        interceptor.addInnerInterceptor(new KeyGeneratorInterceptor());
        return interceptor;
    }
}
