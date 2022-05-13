package es.springboot.dangomvel;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import es.springboot.dto.AsteroidDTO;
import es.springboot.dto.NearEarthObjects;
import es.springboot.dto.PetitionResult;

@RestController
public class NasaRestEndpoint {
	
	@Value("${API_KEY}") 
	private String apiKey;
	
	private static final String ATRIBUTO_ASTEROIDES = "near_earth_objects";
	
	@GetMapping("/asteroids") 
	public PetitionResult getAsteroidsNasa(@RequestParam(required = true) int days) throws JsonMappingException, JsonProcessingException, ParseException{
		
		return consumeNasaApi(days);
	}

	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public String handleMissingParams(MissingServletRequestParameterException ex) {
	    String name = ex.getParameterName();

	    return name + " parameter is missing";
	}
	
	
	private PetitionResult consumeNasaApi(int days) throws JsonMappingException, JsonProcessingException, ParseException {
	
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
		Map<String, Object> nearEarth = (Map<String, Object>) json.get(ATRIBUTO_ASTEROIDES);
	    NearEarthObjects neo = new NearEarthObjects();

	    for(String e : nearEarth.keySet()) {
	    	
	    	neo.getArraysAsteroids().put(e, (List<AsteroidDTO>) nearEarth.get(e));
	    }
	    
	    pr.setListAsteroids(neo);
	    
	    return pr;

	}
	
	private PetitionResult tratamientoFiltradoDatos(PetitionResult pr) {
		PetitionResult prFinal = new PetitionResult();
		
		
		return prFinal;
	}
}
