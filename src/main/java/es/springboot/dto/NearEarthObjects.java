package es.springboot.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NearEarthObjects {
	
	private Map<String, List<AsteroidDTO>> arraysAsteroids;

	public Map<String, List<AsteroidDTO>> getArraysAsteroids() {
		return arraysAsteroids;
	}

	public void setArraysAsteroids(Map<String, List<AsteroidDTO>> arraysAsteroids) {
		this.arraysAsteroids = arraysAsteroids;
	}
	
	public NearEarthObjects() {
		this.arraysAsteroids = new HashMap<String, List<AsteroidDTO>>();
	}
}
