package com.southsystem.fileprocessor;

import com.southsystem.fileprocessor.service.FilePublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FileProcessorApplication {

	@Autowired
	FilePublisherService filePublisherService;

	public static void main(String[] args) {
		SpringApplication.run(FileProcessorApplication.class, args);
		filePublisherService.readDirectory();
	}

}
