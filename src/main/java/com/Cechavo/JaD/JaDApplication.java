package com.Cechavo.JaD;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.Cechavo"})
@SpringBootApplication
public class JaDApplication {

	public static void main(String[] args) {
		SpringApplication.run(JaDApplication.class, args);

	}
}
