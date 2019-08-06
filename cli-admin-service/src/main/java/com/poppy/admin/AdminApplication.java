package com.poppy.admin;

import com.codahale.metrics.ConsoleReporter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@MapperScan("com.poppy.admin.dao")
public class AdminApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(AdminApplication.class, args);

		ConsoleReporter reporter = ctx.getBean(ConsoleReporter.class);
		reporter.start(1, TimeUnit.SECONDS);

	}
}
