package com.vates.pojo;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Temperature {
	@SerializedName("Metric")
	private Metric metric;
	@SerializedName("Imperial")
	private Imperial imperial;
}
