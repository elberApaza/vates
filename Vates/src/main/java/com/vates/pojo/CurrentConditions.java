package com.vates.pojo;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class CurrentConditions {
	@SerializedName("LocalObservationDateTime")
	private String localObservationDateTime;
	@SerializedName("EpochTime")
	private Integer epochTime;
	@SerializedName("WeatherText")
	private String weatherText;
	@SerializedName("WeatherIcon")
	private Integer weatherIcon;
	@SerializedName("HasPrecipitation")
	private Boolean hasPrecipitation;
	@SerializedName("PrecipitationType")
	private String precipitationType;
	@SerializedName("IsDayTime")
	private Boolean isDayTime;
	@SerializedName("Temperature")
	private Temperature temperature;
	@SerializedName("MobileLink")
	private String mobileLink;
	@SerializedName("Link")
	private String link;
	
}
