package com.vates.pojo;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Imperial {
	@SerializedName("Value")
	private double value;
	@SerializedName("Unit")
	private String unit;
	@SerializedName("UnitType")
	private Integer unitType;
}
