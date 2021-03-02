package com.basic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @user: jz
 * @date: 2021/2/23 下午6:11
 * @todo: 主启动类
 */
@SpringBootApplication
@MapperScan(basePackages = "com.basic.mapper")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
