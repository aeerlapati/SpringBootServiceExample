package com.training.project102;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.training.project102"})
public class Project101Application {

	public static void main(String[] args) {
		SpringApplication.run(Project101Application.class, args);
	}
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

		return application.sources(Project101Application.class);

	}

}
