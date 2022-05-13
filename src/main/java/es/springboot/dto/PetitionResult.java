package es.springboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PetitionResult {
	
	@JsonProperty("near_earth_objects")
	private NearEarthObjects listAsteroids;
	
	public PetitionResult() {}

	public NearEarthObjects getListAsteroids() {
		return listAsteroids;
	}

	public void setListAsteroids(NearEarthObjects listAsteroids) {
		this.listAsteroids = listAsteroids;
	}
	
	
}
