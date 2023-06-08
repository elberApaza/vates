package vates.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "accuWeather", url = "${accuWeather-url}")
public interface Client {
	@GetMapping("/currentconditions/v1/")
	String getCurrentConditions();
}

