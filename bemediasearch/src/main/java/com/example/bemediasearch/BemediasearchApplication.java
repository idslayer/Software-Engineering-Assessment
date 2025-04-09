package com.example.bemediasearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BemediasearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(BemediasearchApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplateBuilder()
			.messageConverters(new MappingJackson2HttpMessageConverter())
			.build();
	}

}

