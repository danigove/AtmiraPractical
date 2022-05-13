package es.springboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CloseApproachDataDTO {
	
	@JsonProperty("relative_velocity")
	public RelativeVelocityDTO relativeVelocity;

}
