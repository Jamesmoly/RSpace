package com.researchspace.samples;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SamplesAPI {

	private final RestTemplate restTemplate;
	
	@Value("${api.base.url}")
	String baseUrl;
	@Value("${api.key}")
	String apiKey;

	private String resource = "samples";
	
	public SamplesResponse getSamples() {		
		
		// create headers
		HttpHeaders headers = new HttpHeaders();
		headers.add("apiKey", apiKey);
		

		// build URL string 
		String url = UriComponentsBuilder.fromHttpUrl(baseUrl + resource)
			.toUriString();
		        
		// build the request
		HttpEntity<String> request = new HttpEntity<>(headers);

		// make an HTTP GET request with headers
		ResponseEntity<SamplesResponse> response = restTemplate.exchange(
				url,
		        HttpMethod.GET,
		        request,
		        SamplesResponse.class
		);
		
		return response.getBody();
	}
}
