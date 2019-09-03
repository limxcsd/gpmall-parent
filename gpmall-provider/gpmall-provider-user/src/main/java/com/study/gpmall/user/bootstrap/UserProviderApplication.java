package com.study.gpmall.user.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @ClassName: UserProviderApplication
 * @Description: 用户服务提供者启动类
 * @author: limingxing
 * @Date: 2019-09-03 14:55
 */
@SpringBootApplication
@MapperScan("com.study.gpmall.user.dal.mapper")
@ComponentScan(basePackages = "com.study.gpmall.user")
public class UserProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserProviderApplication.class, args);
        System.out.println("start UserProviderApplication   Success.............");
    }
}
