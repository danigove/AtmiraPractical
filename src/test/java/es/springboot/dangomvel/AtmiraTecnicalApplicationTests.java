package es.springboot.dangomvel;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.InputMismatchException;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.client.HttpClientErrorException;

import es.springboot.dto.AsteroidResult;


@AutoConfigureMockMvc
@SpringBootTest()
class AtmiraTecnicalApplicationTests {

	@Autowired
	private MockMvc  mockMvc;
	
	@Autowired
	private NasaRestEndpoint nasa;
	
	
	@Before
	public void setUp() {
		NasaRestEndpoint controller = new NasaRestEndpoint(); 
	    this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build(); 
	}

	@Test
	void testWithHttpClientErrorException() {
		try {
			nasa.getAsteroidsNasa(9);
		} catch (Exception e) {
			assertTrue(e instanceof HttpClientErrorException);
		}
	}
	
	@Test
	void testNormalResult() {
		try {
			List<AsteroidResult> result = nasa.getAsteroidsNasa(6);
			assertTrue(result.size() == 3);
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	void testWithInputMismatchException() {
		try {
			mockMvc.perform(get("/asteroids").param("days", "ñ"));
		} catch (Exception e) {
			assertTrue(e instanceof InputMismatchException);
		}
	}
	
	@Test
	void testWithMissingServletRequestParameterException() {
		try {
			mockMvc.perform(get("/asteroids"));
		} catch (Exception e) {
			assertTrue(e instanceof MissingServletRequestParameterException);
		}
	}
	
	
	
	

}