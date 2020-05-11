package com.cts.review;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.CrossOrigin;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@CrossOrigin
@EnableSwagger2
@EnableWebSecurity
public class ReviewServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewServiceApplication.class, args);
	}
	
	@Bean
	Docket configureSwagger() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/reviews/**"))
				.build()
				
				.apiInfo(new ApiInfo("Review API Documentation",
						"A Sample API for review",
						"1.0.0",
						"Shopping is Fun",
						new Contact("Yaswanth", "www.tkcorporation.com", "tkyr24898@gmail.com"),
						"Standard API License",
						"www.yaswanth.com",
						Collections.emptyList()));
							
	}

}
