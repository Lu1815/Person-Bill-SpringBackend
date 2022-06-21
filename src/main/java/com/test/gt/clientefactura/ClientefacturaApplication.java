package com.test.gt.clientefactura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ClientefacturaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientefacturaApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/persona").allowedOrigins("http://localhost:3000");
				registry.addMapping("/factura").allowedOrigins("http://localhost:3000");
			}
		};
	}
}
