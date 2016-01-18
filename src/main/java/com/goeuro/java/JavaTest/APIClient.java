package com.goeuro.java.JavaTest;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

/**
 * The API Client Class
 * responsible for calls to the restful call to GoEuro's API
 * 
 * @author ah
 *
 */
public class APIClient {
	
	private final static Logger LOGGER = Logger.getLogger(APIClient.class.getName()); 
	
	private static final String GOEURO_API_URI = "http://api.goeuro.com/api/v2";
	private static final String API_SUGGEST_URI = GOEURO_API_URI + "/position/suggest/en/{cityname}";
	
	/**
	 * Gets the locations related to the given city from GoEuro's API
	 * 
	 * @param city
	 * @return
	 * @throws Exception 
	 */
	public String GetLocations(String city) throws Exception
    {
		LOGGER.setLevel(Level.SEVERE);
		
		final String uri = API_SUGGEST_URI;
		LOGGER.info(String.format("Started to get locations for city: %s, using uri: %s.", 
				city, uri));
	
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        
        LOGGER.info("Finished creating request, calling the api...");
        ResponseEntity<String> result = null;
        try {
        	result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class, city);
        } catch(Exception ex) {
        	LOGGER.severe(String.format("Error in restTemplate.exchange: %s.", ex.toString()));
        	throw ex;
        }
        LOGGER.info(String.format("Received response from the api: %s .", result));
        return result.getBody();
    }
}
