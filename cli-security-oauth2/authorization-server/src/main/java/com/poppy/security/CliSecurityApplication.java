package com.poppy.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.poppy.security.mapper")
public class CliSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(CliSecurityApplication.class, args);
    }

}
