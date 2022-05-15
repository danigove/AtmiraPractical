package es.springboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EstimatedDiameterDTO {
	
	@JsonProperty("kilometers")
	private KilometersDTO kilometers;
	
	@JsonProperty("feet")
	private KilometersDTO feet;
	
	@JsonProperty("meters")
	private KilometersDTO meters;
	
	@JsonProperty("miles")
	private KilometersDTO miles;
	
	public EstimatedDiameterDTO() {
		
	}

	public KilometersDTO getKilometers() {
		return kilometers;
	}

	public void setKilometers(KilometersDTO kilometers) {
		this.kilometers = kilometers;
	}

	public KilometersDTO getFeet() {
		return feet;
	}

	public void setFeet(KilometersDTO feet) {
		this.feet = feet;
	}

	public KilometersDTO getMeters() {
		return meters;
	}

	public void setMeters(KilometersDTO meters) {
		this.meters = meters;
	}

	public KilometersDTO getMiles() {
		return miles;
	}

	public void setMiles(KilometersDTO miles) {
		this.miles = miles;
	}

	
}
