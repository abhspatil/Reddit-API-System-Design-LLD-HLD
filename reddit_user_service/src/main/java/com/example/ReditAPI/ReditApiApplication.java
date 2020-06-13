package com.example.ReditAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ReditApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReditApiApplication.class, args);
	}

}
