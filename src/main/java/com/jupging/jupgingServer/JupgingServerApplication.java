package com.jupging.jupgingServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class JupgingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(JupgingServerApplication.class, args);
	}

}
