package com.pro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.pro.mapper")
public class DemoMeituanManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoMeituanManagerApplication.class, args);
    }

}
