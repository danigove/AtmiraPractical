package es.springboot.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AsteroidDTO //implements Comparable
{
	
	@JsonProperty("is_potentially_hazardous_asteroid")
	public String isPotentiallyHazardousAsteroid;
	
	@JsonProperty("is_sentry_object")
	public String isSentryObject;

	@JsonProperty("absolute_magnitude_h")
	public String absoluteMagnitudeH;
	
	@JsonProperty("links")
	private Links links;
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("estimated_diameter")
	private EstimatedDiameterDTO estimatedDiameter;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("neo_reference_id")
	private String neoReferenceId;
	
	@JsonProperty("nasa_jpl_url")
	private String nasaJplUrl;
	
	@JsonProperty("close_approach_data")
	private List<CloseApproachDataDTO> closeApproachData;
	
	@JsonProperty("close_approach_date")
	private CloseApproachDateDTO closeApproachDate;
	
	
	public AsteroidDTO(){}
	

	
	public BigDecimal getTamanoMedio() {
		KilometersDTO sd = getEstimatedDiameter().getKilometers();
		return new BigDecimal(sd.getEstimatedDiameterMin()).add(new BigDecimal(sd.getEstimatedDiameterMin())).divide(new BigDecimal(2));
	}


	public String getIsPotentiallyHazardousAsteroid() {
		return isPotentiallyHazardousAsteroid;
	}


	public void setIsPotentiallyHazardousAsteroid(String isPotentiallyHazardousAsteroid) {
		this.isPotentiallyHazardousAsteroid = isPotentiallyHazardousAsteroid;
	}


	public EstimatedDiameterDTO getEstimatedDiameter() {
		return estimatedDiameter;
	}


	public void setEstimatedDiameter(EstimatedDiameterDTO estimatedDiameter) {
		this.estimatedDiameter = estimatedDiameter;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<CloseApproachDataDTO> getCloseApproachData() {
		return closeApproachData;
	}


	public void setCloseApproachData(List<CloseApproachDataDTO> closeApproachData) {
		this.closeApproachData = closeApproachData;
	}


	public CloseApproachDateDTO getCloseApproachDate() {
		return closeApproachDate;
	}


	public void setCloseApproachDate(CloseApproachDateDTO closeApproachDate) {
		this.closeApproachDate = closeApproachDate;
	}



	public String getIsSentryObject() {
		return isSentryObject;
	}



	public void setIsSentryObject(String isSentryObject) {
		this.isSentryObject = isSentryObject;
	}



	public String getAbsoluteMagnitudeH() {
		return absoluteMagnitudeH;
	}



	public void setAbsoluteMagnitudeH(String absoluteMagnitudeH) {
		this.absoluteMagnitudeH = absoluteMagnitudeH;
	}



	public Links getLinks() {
		return links;
	}



	public void setLinks(Links links) {
		this.links = links;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getNeoReferenceId() {
		return neoReferenceId;
	}



	public void setNeoReferenceId(String neoReferenceId) {
		this.neoReferenceId = neoReferenceId;
	}



	public String getNasaJplUrl() {
		return nasaJplUrl;
	}



	public void setNasaJplUrl(String nasaJplUrl) {
		this.nasaJplUrl = nasaJplUrl;
	}

	
	

//	@Override
//	public int compareTo(Object o) {
//		AsteroidDTO ast = (AsteroidDTO) o;
//		return this.getTamanoMedio().compareTo(ast.getTamanoMedio());
//	}

	
	
}
