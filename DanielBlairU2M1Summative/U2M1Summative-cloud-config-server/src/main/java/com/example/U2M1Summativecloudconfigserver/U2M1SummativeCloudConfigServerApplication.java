package com.example.U2M1Summativecloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class U2M1SummativeCloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(U2M1SummativeCloudConfigServerApplication.class, args);
	}

}
