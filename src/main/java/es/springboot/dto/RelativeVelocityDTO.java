package es.springboot.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RelativeVelocityDTO {
	
	@JsonProperty("kilometers_per_hour")
	private BigDecimal kilometersPerHour;


}
