package com.dulanjanalakshan.systemlog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SystemLogApplication {
	public static void main(String[] args) {
		SpringApplication.run(SystemLogApplication.class, args);
	}
}
