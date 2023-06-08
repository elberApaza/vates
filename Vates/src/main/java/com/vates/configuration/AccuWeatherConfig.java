package com.vates.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
public class AccuWeatherConfig {
	
	@Value("${accuWeather-url}")
	private String url;
	
	@Value("${api-key}")
	private String apiKey;
}
