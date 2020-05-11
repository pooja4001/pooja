package com.capgemini.backgroundverification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer
@SpringBootApplication
public class EurekaServerBackgroundVerificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerBackgroundVerificationApplication.class, args);
	}

}

