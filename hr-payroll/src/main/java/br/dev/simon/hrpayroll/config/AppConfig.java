package br.dev.simon.hrpayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

	// Singleton Design Pattern.
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
