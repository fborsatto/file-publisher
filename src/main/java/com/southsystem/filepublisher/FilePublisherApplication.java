package com.southsystem.filepublisher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
public class FilePublisherApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilePublisherApplication.class, args);
	}

}
