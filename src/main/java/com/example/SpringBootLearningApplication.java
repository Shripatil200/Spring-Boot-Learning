package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.example.mapping_annotations")
@SpringBootApplication
public class SpringBootLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLearningApplication.class, args);
	}

}
