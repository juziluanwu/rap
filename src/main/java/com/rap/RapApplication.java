package com.rap;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@MapperScan(basePackages = { "com.rap.mapper.**"})
public class RapApplication {
    public static void main(String[] args) {
        SpringApplication.run(RapApplication.class, args);
    }

}
