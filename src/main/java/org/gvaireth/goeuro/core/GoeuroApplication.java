package org.gvaireth.goeuro.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan({ "org.gvaireth.goeuro.core", "org.gvaireth.goeuro.server" })
@EnableAutoConfiguration
@Configuration
public class GoeuroApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoeuroApplication.class, args);
		System.out.println("hello world!");
	}
}
