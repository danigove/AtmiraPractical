package es.springboot.dangomvel;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NasaRestEndpoint {
	
	@GetMapping("/asteroids")
	public String getAsteroidsNasa(@RequestParam @Min(1) @Max(7)int days){
		
		return "Dias: " + days;
	}

}
