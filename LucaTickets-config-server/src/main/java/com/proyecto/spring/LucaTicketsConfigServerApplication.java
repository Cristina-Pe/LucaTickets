package com.proyecto.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class LucaTicketsConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LucaTicketsConfigServerApplication.class, args);
	}

}
