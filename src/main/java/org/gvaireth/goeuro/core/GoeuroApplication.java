package org.gvaireth.goeuro.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan({ "org.gvaireth.goeuro.core", "org.gvaireth.goeuro.server", "org.gvaireth.goeuro.rest" })
@EnableAutoConfiguration
@Configuration
public class GoeuroApplication {

	public static String FILE = null;

	public static void main(String[] args) {
		FILE = args[0];// note: todo:fix this abomination
		SpringApplication.run(GoeuroApplication.class, args);
		System.out.println("app healthy!");
		System.out.println("route file location: " + FILE);
	}
}
