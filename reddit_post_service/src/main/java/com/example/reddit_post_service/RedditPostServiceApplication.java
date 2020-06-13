package com.example.reddit_post_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class RedditPostServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedditPostServiceApplication.class, args);
	}

}
