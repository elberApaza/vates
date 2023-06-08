package com.vates.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table
@Entity
public class Temperature {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "metric_id")
	private Metric metric;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "imperial_id")
	private Imperial imperial;
	
	@OneToOne(mappedBy = "temperature")
	private CurrentConditions currentConditions;
}
