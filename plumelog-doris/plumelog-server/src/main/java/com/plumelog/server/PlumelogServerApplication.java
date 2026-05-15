package com.plumelog.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * plumelog应用程序启动类
 *
 * @author Frank.chen
 * @version 1.0.0
 * @since 2020/6/10 17:40
 */
@SpringBootApplication
@EnableAsync
@EnableScheduling
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.plumelog"})
@MapperScan("com.plumelog.server.mapper")
public class PlumelogServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlumelogServerApplication.class, args);
    }

}
