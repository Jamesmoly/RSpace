package com.researchspace.samples;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.Mockito.anyString;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;

import com.researchspace.samples.model.Quantity;
import com.researchspace.samples.model.Sample;

@ExtendWith(MockitoExtension.class)
public class SamplesCommandLineTest{

	@Mock 
	SamplesAPI samplesAPIMock;
	
	@Mock 
	ExitApp exitAppMock;
	
	@Mock 
	ConsoleWriter consoleWriterMock;
	
	@Mock 
	ConsoleReader consoleReaderMock;
	
	@Mock
	SamplesResponse samplesResponseMock;
	

	
	@InjectMocks
	private SamplesCommandLine samplesCommandLine;
	


	@Test
	public void testRequestFailsNotFound() throws Exception {
		doThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND)).when(samplesAPIMock).getSamples();
	
		samplesCommandLine.run(new String[0]);
		
		verify(exitAppMock, atLeast(1)).exit(1, String.format("Error retrieving samples. Returned status code of %1$s", HttpStatus.NOT_FOUND));		
	}
	
	@Test
	public void testRequestUnauthorized() throws Exception {
		doThrow(new HttpClientErrorException(HttpStatus.UNAUTHORIZED)).when(samplesAPIMock).getSamples();
	
		samplesCommandLine.run(new String[0]);
		
		verify(exitAppMock, atLeast(1)).exit(1, String.format("Error retrieving samples. Returned status code of %1$s", HttpStatus.UNAUTHORIZED));		
	}
		
	@Test
	public void testRequestFailsOther() throws Exception {
		doThrow(new ResourceAccessException(null)).when(samplesAPIMock).getSamples();
	
		samplesCommandLine.run(new String[0]);
		
		verify(exitAppMock, atLeast(1)).exit(1, "Error retrieving samples null");		
	}
	
	@Test
	public void testUserExitsApplicationBeforeViewing() throws Exception {
	
		when(samplesAPIMock.getSamples()).thenReturn(samplesResponseMock);
		when(consoleReaderMock.read(anyString())).thenReturn("N");
		samplesCommandLine.run(new String[0]);
		
		verify(exitAppMock, atLeast(1)).exit(0, "Thank you for using sample viewer");		
	}
	
	@Test
	public void testSamplesDisplayed() throws Exception {
		
		Sample sample1Mock = mock(Sample.class);
		Quantity quantity = mock(Quantity.class);
		
		when(sample1Mock.getName()).thenReturn("Sample1");	
		when(quantity.getNumericValue()).thenReturn(new BigDecimal(20));
		when(sample1Mock.getStorageTempMax()).thenReturn(quantity);	
		when(quantity.getNumericValue()).thenReturn(new BigDecimal(10));
		when(sample1Mock.getStorageTempMin()).thenReturn(quantity);
		when(sample1Mock.getExpiryDate()).thenReturn("2021-10-25");

		when(samplesAPIMock.getSamples()).thenReturn(samplesResponseMock);
		when(samplesResponseMock.getSamples()).thenReturn(List.of(sample1Mock));
		when(consoleReaderMock.read(anyString())).thenReturn("Y");
		samplesCommandLine.run(new String[0]);
		
		verify(consoleWriterMock, atLeast(1)).println("Name                 | Min Temp/°C     | Max Temp/°C     | Expiry Date          \r\n");	
		verify(consoleWriterMock, atLeast(1)).println("Sample1              | 10              | 10              | 2021-10-25           \r\n");
	}
	
	

	

}
