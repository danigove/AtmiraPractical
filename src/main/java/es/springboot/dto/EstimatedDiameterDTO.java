package es.springboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EstimatedDiameterDTO {
	
	@JsonProperty("kilometers")
	private KilometersDTO kilometers;
	
	public EstimatedDiameterDTO() {
		
	}

	public KilometersDTO getKilometers() {
		return kilometers;
	}

	public void setKilometers(KilometersDTO kilometers) {
		this.kilometers = kilometers;
	}

	
}
