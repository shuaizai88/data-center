package com.xhb.dc.kettle.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 系统管理启动Main.
 *
 * @author gavin
 * @since 2020-01-09 15:59
 */
@EnableDiscoveryClient
@EnableAutoConfiguration
@EnableSwagger2
@MapperScan(value = "com.xhb.dc.kettle.system.**.mapper")
@ComponentScan(value = {"com.xhb.dc.kettle.system"})
@EnableScheduling
@EnableCaching
public class SystemManagerApplication {

    /**
     * main.
     *
     * @param args args
     */
    public static void main(String[] args) {
        new SpringApplicationBuilder(SystemManagerApplication.class).run(args);
    }

}
