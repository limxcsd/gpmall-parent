package com.study.gpmall.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName: GpmallUserApplication
 * @Description: 用户web模块启动类
 * @author: limingxing
 * @Date: 2019-09-03 16:09
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.study.gpmall.user")
public class GpmallUserApplication {


    public static void main(String[] args) {
        SpringApplication.run(GpmallUserApplication.class,args);
        System.out.println("start GpmallUserApplication SUCCESS............. ");
    }

}
