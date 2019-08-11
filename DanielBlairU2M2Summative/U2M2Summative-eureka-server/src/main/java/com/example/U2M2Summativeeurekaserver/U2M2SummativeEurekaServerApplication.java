package com.example.U2M2Summativeeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class U2M2SummativeEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(U2M2SummativeEurekaServerApplication.class, args);
	}

}
