package com.researchspace.samples;

import java.io.Console;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class SamplesConfiguration {

	
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
	@Bean
	public Console console(){

		Console c = System.console();
		// Error message if console not available
		if(c == null) {
			log.error("Console not found");
			System.exit(0);
		}
		return c;
	}
}
