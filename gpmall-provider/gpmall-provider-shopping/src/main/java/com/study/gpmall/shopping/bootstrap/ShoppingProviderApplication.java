package com.study.gpmall.shopping.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @ClassName: ShoppingProviderApplication
 * @Description:
 * @author: limingxing
 * @Date: 2019-09-03 16:24
 */
@SpringBootApplication
@MapperScan("com.study.gpmall.shopping.dal.mapper")
@ComponentScan(basePackages = "com.study.gpmall.shopping")
public class ShoppingProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingProviderApplication.class, args);
        System.out.println("start ShoppingProviderApplication SUCCESS............. ");
    }

}
