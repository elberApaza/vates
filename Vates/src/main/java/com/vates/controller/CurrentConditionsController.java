package com.vates.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vates.model.CurrentConditions;
import com.vates.service.CurrentConditionService;

@RestController
@RequestMapping("api/vates/currentConditions")
public class CurrentConditionsController {
	
	@Autowired
	private CurrentConditionService currentConditionService;
	
	@PostMapping
	public CurrentConditions createCurrentConditions(CurrentConditions currentConditions) {
		return currentConditionService.createCurrentConditions(currentConditions);
	}
	
	@GetMapping
	public List<CurrentConditions> getAllCurrentConditions(){
		return currentConditionService.getAllConCurrentConditions();		
	}
	
	@GetMapping("{id}")
	public CurrentConditions currentConditionsById(@PathVariable("id") Long id) {
		return currentConditionService.getCurrecurrentConditionsById(id);
	}
}
