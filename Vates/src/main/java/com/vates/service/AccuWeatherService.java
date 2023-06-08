package com.vates.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.vates.configuration.AccuWeatherConfig;
import com.vates.pojo.CurrentConditions;
import com.vates.repository.CurrentConditionsRepository;
import com.vates.utils.Utils;

import lombok.RequiredArgsConstructor;
import vates.client.Client;	

@Service
@RequiredArgsConstructor
public class AccuWeatherService {
	
	@Autowired
    private AccuWeatherConfig accuWeatherConfig;
	
	@Autowired
	private CurrentConditionsRepository currentConditionsRepository;
	
	private Client client;
	
	public void chargeByLocation(String locationId) {
		
		
//		problemas con el client
		//String currentConditions = client.getCurrentConditions();

//		 tuve que aplicar lo siguiente para poder consumir el servicio
		RestTemplate restTemplate = new RestTemplate();
		String url = accuWeatherConfig.getUrl() + "/currentconditions/v1/" + locationId.toString() + "?apikey="+accuWeatherConfig.getApiKey();
		HttpHeaders headers = new HttpHeaders();
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
		
		CurrentConditions[] currentConditions = new Gson().fromJson(response.getBody(), CurrentConditions[].class);
		
		com.vates.model.CurrentConditions cur = mapCurrentConditions(currentConditions);
		
		currentConditionsRepository.save(cur);
	
		
		System.out.println(currentConditions);
	}
	
	
	public com.vates.model.CurrentConditions mapCurrentConditions(CurrentConditions[] currentConditions) {
		com.vates.model.CurrentConditions currentConditionsModel = new com.vates.model.CurrentConditions();
		
		for (CurrentConditions currentConditions2 : currentConditions) {
			currentConditionsModel.setLocalObservationDateTime(Utils.convertStringToDate(currentConditions2.getLocalObservationDateTime(), "yyyy-MM-dd'T'HH:mm:ssXXX"));
			currentConditionsModel.setEpochTime(currentConditions2.getEpochTime());
			currentConditionsModel.setWeatherText(currentConditions2.getWeatherText());
			currentConditionsModel.setWeatherIcon(currentConditions2.getWeatherIcon());
			currentConditionsModel.setPrecipitationType(currentConditions2.getPrecipitationType());
			currentConditionsModel.setIsDayTime(currentConditions2.getIsDayTime());
			currentConditionsModel.getTemperature().getMetric().setValue(currentConditions2.getTemperature().getMetric().getValue());
			currentConditionsModel.getTemperature().getMetric().setUnit(currentConditions2.getTemperature().getMetric().getUnit());
			currentConditionsModel.getTemperature().getMetric().setUnitType(currentConditions2.getTemperature().getMetric().getUnitType());
			currentConditionsModel.getTemperature().getImperial().setValue(currentConditions2.getTemperature().getImperial().getValue());
			currentConditionsModel.getTemperature().getImperial().setUnit(currentConditions2.getTemperature().getImperial().getUnit());
			currentConditionsModel.getTemperature().getImperial().setUnitType(currentConditions2.getTemperature().getImperial().getUnitType());
			currentConditionsModel.setMobileLink(currentConditions2.getMobileLink());
			currentConditionsModel.setLink(currentConditions2.getLink());

		}

		return currentConditionsModel;
	}
		
}
