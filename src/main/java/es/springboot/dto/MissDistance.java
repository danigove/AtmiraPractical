package es.springboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MissDistance {

	@JsonProperty("astronomical")
	private String astronomical;
	
	@JsonProperty("kilometers")
	private String kilometers;

	@JsonProperty("lunar")
	private String lunar;

	@JsonProperty("miles")
	private String miles;

	public MissDistance() {
		
	}

	public String getAstronomical() {
		return astronomical;
	}

	public void setAstronomical(String astronomical) {
		this.astronomical = astronomical;
	}

	public String getKilometers() {
		return kilometers;
	}

	public void setKilometers(String kilometers) {
		this.kilometers = kilometers;
	}

	public String getLunar() {
		return lunar;
	}

	public void setLunar(String lunar) {
		this.lunar = lunar;
	}

	public String getMiles() {
		return miles;
	}

	public void setMiles(String miles) {
		this.miles = miles;
	}
	
	
	
	
}
