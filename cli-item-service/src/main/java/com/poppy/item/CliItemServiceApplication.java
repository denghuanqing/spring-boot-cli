package com.poppy.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CliItemServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CliItemServiceApplication.class, args);
	}
}
