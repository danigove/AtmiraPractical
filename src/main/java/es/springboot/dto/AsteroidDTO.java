package es.springboot.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AsteroidDTO {
	
	@JsonProperty("is_potentially_hazardous_asteroid")
	public String isPotentiallyHazardousAsteroid;
	
	@JsonProperty("estimated_diameter")
	private EstimatedDiameterDTO estimatedDiameter;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("close_approach_data")
	private List<CloseApproachDataDTO> closeApproachData;
	
	@JsonProperty("close_approach_date")
	private CloseApproachDateDTO closeApproachDate;
	
	
	public AsteroidDTO(){}

	
}
