package es.springboot.dangomvel;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import es.springboot.dto.AsteroidDTO;
import es.springboot.dto.AsteroidResult;
import es.springboot.dto.NearEarthObjects;
import es.springboot.dto.PetitionResult;

@RestController
public class NasaRestEndpoint {
	
	@Value("${API_KEY}") 
	private String apiKey;
	
	private static final String ATRIBUTO_ASTEROIDES = "near_earth_objects";
	
	@GetMapping("/asteroids") 
	public List<AsteroidResult> getAsteroidsNasa(@RequestParam(required = true) int days) throws JsonMappingException, JsonProcessingException, ParseException{
		
		return consumeNasaApi(days);
	}

	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public String handleMissingParams(MissingServletRequestParameterException ex) {
	    String name = ex.getParameterName();

	    return name + " parameter is missing";
	}
	
	@ExceptionHandler(HttpClientErrorException.class)
	public String handleError400(HttpClientErrorException ex) {
	  
		return ex.getLocalizedMessage();
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public String handleMissingParams(MethodArgumentTypeMismatchException ex) {

	    return "El parámetro tiene que ser un número";
	}
	
	private List<AsteroidResult> consumeNasaApi(int days) throws JsonMappingException, JsonProcessingException, ParseException {
	
		String url = generacionUrl(days);
		
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(url, String.class);	

		
		PetitionResult pr = tratamientoResultadoPeticion(result);
		
		return tratamientoFiltradoDatos(pr);
	}
	
	private String generacionUrl(int days) {
		SimpleDateFormat parseador = new SimpleDateFormat("yyyy-MM-dd");
		LocalDateTime ldt = LocalDateTime.now();
		String stringFechaActual = parseador.format(Timestamp.valueOf(ldt));
		ldt = ldt.plusDays(days);
		String stringFechaHasta = parseador.format(Timestamp.valueOf(ldt));
		return String.format("https://api.nasa.gov/neo/rest/v1/feed?start_date=%s&end_date=%s&api_key=%s",stringFechaActual, stringFechaHasta, apiKey);
		
	}
	
	@SuppressWarnings("unchecked")
	private PetitionResult tratamientoResultadoPeticion(String result) throws ParseException {

	    PetitionResult pr= new PetitionResult();
	    JSONParser parser = new JSONParser();
	    JSONObject json = (JSONObject) parser.parse(result);
		Map<String, AsteroidDTO> nearEarth = (Map<String, AsteroidDTO>) json.get(ATRIBUTO_ASTEROIDES);
	    NearEarthObjects neo = new NearEarthObjects();

	    for(String e : nearEarth.keySet()) {
	    	
	    	neo.getArraysAsteroids().put(e, (List<JSONObject>) nearEarth.get(e));
	    }
	    
	    pr.setListAsteroids(neo);
	    
	    return pr;

	}
	
	private List<AsteroidResult> tratamientoFiltradoDatos(PetitionResult pr) throws ParseException {
		List<JSONObject> asteroids = pr.getListAsteroids().getAllAsteroids();
		List<AsteroidResult> asteroidsResult = obtenerAsteoidsResult(asteroids);
		List<AsteroidResult> asteroidsAux = asteroidsResult.stream().sorted(Collections.reverseOrder()).limit(3).toList();
		return asteroidsAux;
	}
	
//Explicacion: Dado que no tengo tiempo para ver porque la conversion a DTO con el @jsonProperty no se ha realizado, he optado por hacerlo a lo bruto para al menos poder terminar la tarea
	
	private List<AsteroidResult>  obtenerAsteoidsResult(List<JSONObject> asteroids) throws ParseException{

		 List<AsteroidResult> aux = new  ArrayList<AsteroidResult>();
		 
		 for(JSONObject ast:  asteroids) {
			 String name = ast.get("name").toString();
			 
			 JSONParser parser = new JSONParser();
			 JSONObject estimatedDiameter = (JSONObject) parser.parse(ast.get("estimated_diameter").toString());
			 JSONObject kilometers = (JSONObject) parser.parse(estimatedDiameter.get("kilometers").toString());

			 BigDecimal maxDiam = new BigDecimal(kilometers.get("estimated_diameter_max").toString());
			 BigDecimal minDiam = new BigDecimal(kilometers.get("estimated_diameter_min").toString());
			 BigDecimal mediaDiam = maxDiam.add(minDiam).divide(new BigDecimal(2));
			 
			 JSONArray closeApproachData = (JSONArray) parser.parse(ast.get("close_approach_data").toString());
			 
			 JSONObject closeApproachDataObject = (JSONObject) parser.parse(closeApproachData.get(0).toString());

			 JSONObject velocityRelativa = (JSONObject) parser.parse(closeApproachDataObject.get("relative_velocity").toString());
			 
			 String kmHour = velocityRelativa.get("kilometers_per_hour").toString();
			 String dateApproach = closeApproachDataObject.get("close_approach_date").toString();
			 String planeta = closeApproachDataObject.get("orbiting_body").toString();
			 
			 aux.add(new AsteroidResult(name, mediaDiam, kmHour, dateApproach, planeta));
		 }
		 
		 return aux;
	}
	
	
	
	
	
	
	
}
