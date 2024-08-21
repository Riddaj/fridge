package com.example.fridgemanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
		        .allowedOrigins("http://localhost:8080") // Vue.js 개발 서버 주소
		        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
		        .allowedHeaders("*")
		        .allowCredentials(true);
	}
}