package com.vates;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableFeignClients
@SpringBootApplication
@Configuration
@EnableScheduling
public class VatesApplication {

	public static void main(String[] args) {
		SpringApplication.run(VatesApplication.class, args);
		
	}


}
