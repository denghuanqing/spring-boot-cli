package com.poppy.item;

//import com.poppy.item.stream.StreamResource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableBinding(StreamResource.class)
public class CliItemServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CliItemServiceApplication.class, args);
	}
}
