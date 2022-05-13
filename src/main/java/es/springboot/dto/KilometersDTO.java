package es.springboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KilometersDTO {
	
	@JsonProperty("estimated_diameter_min")
	public String estimatedDiameterMin;
	
	@JsonProperty("estimated_diameter_max")
	public String estimatedDiameterMax;

	
	public KilometersDTO() {
		
	}


	public String getEstimatedDiameterMin() {
		return estimatedDiameterMin;
	}


	public void setEstimatedDiameterMin(String estimatedDiameterMin) {
		this.estimatedDiameterMin = estimatedDiameterMin;
	}


	public String getEstimatedDiameterMax() {
		return estimatedDiameterMax;
	}


	public void setEstimatedDiameterMax(String estimatedDiameterMax) {
		this.estimatedDiameterMax = estimatedDiameterMax;
	}
	
	
}
