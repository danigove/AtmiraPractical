package es.springboot.dangomvel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class NasaRestEndpoint {
	
	@Value("${API_KEY}") 
	private String apiKey;
	
	@GetMapping("/asteroids") 
	public String getAsteroidsNasa(@RequestParam(required = true) int days){
		
		return consumeNasaApi(days);
	}

	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public String handleMissingParams(MissingServletRequestParameterException ex) {
	    String name = ex.getParameterName();

	    return name + " parameter is missing";
	}
	
	
	private String consumeNasaApi(int days) {
		
		//TODO: Formatear dates con days
		String url = "https://api.nasa.gov/neo/rest/v1/feed?start_date=2021-12-09&end_date=2021-12-12&api_key=" + apiKey;
		
		RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(url, String.class);	
	    return result;
		
	}
}
