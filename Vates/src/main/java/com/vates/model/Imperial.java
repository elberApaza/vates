package com.vates.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table
@Entity
public class Imperial {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(insertable = false, updatable = false)
	private double value;
	
	@Column(insertable = false, updatable = false)
	private String unit;
	
	@Column(name = "unit_type", insertable = false, updatable = false)
	private Integer unitType;
	
	@OneToOne(mappedBy = "imperial")
    private Temperature temperature;
}
