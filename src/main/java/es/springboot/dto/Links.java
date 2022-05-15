package es.springboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Links {

	@JsonProperty("self")
	private String self;

	public Links() {
		
	}
	
	public String getSelf() {
		return self;
	}

	public void setSelf(String self) {
		this.self = self;
	}
	
	
}
