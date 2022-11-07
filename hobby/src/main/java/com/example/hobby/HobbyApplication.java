package com.example.hobby;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HobbyApplication {

	public static void main(String[] args) {
		SpringApplication.run(HobbyApplication.class, args);
	}

}
