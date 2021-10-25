package com.researchspace.samples;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.anyString;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import com.researchspace.samples.model.Sample;

@ExtendWith(MockitoExtension.class)
public class SamplesAPITest {

	@Mock 
	RestTemplate restTemplateMock;
	
	@InjectMocks
	private SamplesAPI samplesAPI;
	
	@BeforeEach
	void setUp() {
		// Add @Value fields
		ReflectionTestUtils.setField(samplesAPI, "baseUrl", "http://someurl/");
		ReflectionTestUtils.setField(samplesAPI, "apiKey", "44444444444444444");
	}
	
	@Test
	public void testRequestSuccessful() {
		
		
		Sample testSample1 = new Sample();
		testSample1.setName("Test Sample 1");
		
		SamplesResponse samplesResponse = new SamplesResponse();
		samplesResponse.setSamples(List.of(testSample1));
		samplesResponse.setTotalHits(2);
		
		when(restTemplateMock.exchange(eq("http://someurl/samples"), eq(HttpMethod.GET), any(HttpEntity.class), eq(SamplesResponse.class))).thenReturn(new ResponseEntity<SamplesResponse>(samplesResponse, HttpStatus.OK));
		
		SamplesResponse samples = samplesAPI.getSamples();
		
		assertEquals(List.of(testSample1), samples.getSamples());
		
	}
	

	@Test
	public void testRequestFailsNotFound() {

		when(restTemplateMock.exchange(anyString(), eq(HttpMethod.GET), any(HttpEntity.class), eq(SamplesResponse.class))).thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));
		
		assertThrows(HttpClientErrorException.class, () -> {
			samplesAPI.getSamples();
		});
		
	}
	
	@Test
	public void testRequestFailsNotAuthorized() {

		when(restTemplateMock.exchange(anyString(), eq(HttpMethod.GET), any(HttpEntity.class), eq(SamplesResponse.class))).thenThrow(new HttpClientErrorException(HttpStatus.UNAUTHORIZED));
		
		assertThrows(HttpClientErrorException.class, () -> {
			samplesAPI.getSamples();
		});
		
	}
	

}
