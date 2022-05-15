package es.springboot.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RelativeVelocityDTO {
	
	@JsonProperty("kilometers_per_hour")
	private BigDecimal kilometersPerHour;

	@JsonProperty("kilometers_per_second")
	private BigDecimal kilometersPerSecond;
	
	@JsonProperty("miles_per_hour")
	private BigDecimal milesPerHour;

	public RelativeVelocityDTO() {
		
	}
	
	public BigDecimal getKilometersPerHour() {
		return kilometersPerHour;
	}

	public void setKilometersPerHour(BigDecimal kilometersPerHour) {
		this.kilometersPerHour = kilometersPerHour;
	}

	public BigDecimal getKilometersPerSecond() {
		return kilometersPerSecond;
	}

	public void setKilometersPerSecond(BigDecimal kilometersPerSecond) {
		this.kilometersPerSecond = kilometersPerSecond;
	}

	public BigDecimal getMilesPerHour() {
		return milesPerHour;
	}

	public void setMilesPerHour(BigDecimal milesPerHour) {
		this.milesPerHour = milesPerHour;
	}
	
	

}
