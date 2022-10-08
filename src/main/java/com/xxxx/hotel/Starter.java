package com.xxxx.hotel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xxxx.hotel.dao")
public class Starter {

    public static void main(String[] args) {
        SpringApplication.run(Starter.class);
    }
}
