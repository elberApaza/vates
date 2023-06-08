package com.vates.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vates.service.AccuWeatherService;

@RestController
@RequestMapping("/api/vates")
public class AccuWeatherController {
	
	@Autowired
	private AccuWeatherService accuWeatherService;
	
	@GetMapping("/charge/byLocation/{locationId}")
	public void chargeByLocation(@PathVariable String locationId) {
		accuWeatherService.chargeByLocation(locationId);
	}
}
