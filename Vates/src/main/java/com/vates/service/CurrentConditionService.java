package com.vates.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vates.model.CurrentConditions;
import com.vates.repository.CurrentConditionsRepository;

@Component
public class CurrentConditionService {

	@Autowired
	private CurrentConditionsRepository currentConditionsRepository;
	
	public CurrentConditions createCurrentConditions(CurrentConditions conditions) {
		return currentConditionsRepository.save(conditions);
	}
	
	public CurrentConditions getCurrecurrentConditionsById(Long id) {
		Optional<CurrentConditions> optionalCurrentConditions = currentConditionsRepository.findById(id);
		return optionalCurrentConditions.get();
	}
	
	public List<CurrentConditions> getAllConCurrentConditions(){
		return currentConditionsRepository.findAll();
	}
}
