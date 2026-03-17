package com.guchen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.guchen.mapper")
public class TearSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(TearSpringApplication.class, args);
    }

}
