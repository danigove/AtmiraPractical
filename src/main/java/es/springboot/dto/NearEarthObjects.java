package es.springboot.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

public class NearEarthObjects {
	
	private Map<String, List<JSONObject>> arraysAsteroids;

	public Map<String, List<JSONObject>> getArraysAsteroids() {
		return arraysAsteroids;
	}

	public void setArraysAsteroids(Map<String, List<JSONObject>> arraysAsteroids) {
		this.arraysAsteroids = arraysAsteroids;
	}
	
	public NearEarthObjects() {
		this.arraysAsteroids = new HashMap<String, List<JSONObject>>();
	}
	
	public List<JSONObject> getAllAsteroids(){
		List<JSONObject> lista = new ArrayList<>();
		Map<String, List<JSONObject>> map = getArraysAsteroids();
	    for(String e : map.keySet()) {
	    	lista.addAll(map.get(e));
	    }
	    return lista;
	}
	
}
