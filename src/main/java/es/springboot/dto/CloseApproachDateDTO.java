package es.springboot.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CloseApproachDateDTO {
	
	@JsonProperty("close_approach_date")
	private Date closeApproachDate;
	
	@JsonProperty("orbiting_body")
	private String orbitting_body;
	
	public CloseApproachDateDTO() {
		
	}

}
