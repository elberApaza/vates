package com.vates.model;

import java.util.Date;

import javax.persistence.CascadeType;
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
@Entity
@Table(name = "current_conditions")
public class CurrentConditions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date localObservationDateTime;
	private Integer epochTime;
	private String weatherText;
	private Integer weatherIcon;
	private Boolean hasPrecipitation;
	private String precipitationType;
	private Boolean isDayTime;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "temperature_id")
	private Temperature temperature;
	private String mobileLink;
	private String link;
	
}
