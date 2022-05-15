package es.springboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CloseApproachDataDTO {
	
	@JsonProperty("relative_velocity")
	public RelativeVelocityDTO relativeVelocity;

	
	@JsonProperty("orbiting_body")
	private String orbitingBody;
	

	@JsonProperty("close_approach_date")
	private String closeApproachDate;
	
	@JsonProperty("epoch_date_close_approach")
	private String epochDateCloseApproach;
	@JsonProperty("close_approach_date_full")
	private String closeApproachDateFull;
	
	@JsonProperty("miss_distance")
	private MissDistance missDistance;
	
	public CloseApproachDataDTO() {
		
	}

	public RelativeVelocityDTO getRelativeVelocity() {
		return relativeVelocity;
	}

	public void setRelativeVelocity(RelativeVelocityDTO relativeVelocity) {
		this.relativeVelocity = relativeVelocity;
	}

	public String getOrbitingBody() {
		return orbitingBody;
	}

	public void setOrbitingBody(String orbitingBody) {
		this.orbitingBody = orbitingBody;
	}

	public String getCloseApproachDate() {
		return closeApproachDate;
	}

	public void setCloseApproachDate(String closeApproachDate) {
		this.closeApproachDate = closeApproachDate;
	}

	public String getEpochDateCloseApproach() {
		return epochDateCloseApproach;
	}

	public void setEpochDateCloseApproach(String epochDateCloseApproach) {
		this.epochDateCloseApproach = epochDateCloseApproach;
	}

	public String getCloseApproachDateFull() {
		return closeApproachDateFull;
	}

	public void setCloseApproachDateFull(String closeApproachDateFull) {
		this.closeApproachDateFull = closeApproachDateFull;
	}

	public MissDistance getMissDistance() {
		return missDistance;
	}

	public void setMissDistance(MissDistance missDistance) {
		this.missDistance = missDistance;
	}
	
	
	
	
}
