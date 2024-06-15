package com.api.turismo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.api.turismo")
public class TurismoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TurismoApplication.class, args);
	}

}
