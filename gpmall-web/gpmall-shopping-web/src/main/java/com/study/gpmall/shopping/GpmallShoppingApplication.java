package com.study.gpmall.shopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName: GpmallShoppingApplication
 * @Description: 商品购物模块启动类
 * @author: limingxing
 * @Date: 2019-09-03 16:15
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.study.gpmall.shopping")
public class GpmallShoppingApplication {

    public static void main(String[] args) {
        SpringApplication.run(GpmallShoppingApplication.class,args);
        System.out.println("start GpmallShoppingApplication SUCCESS............. ");
    }
}
