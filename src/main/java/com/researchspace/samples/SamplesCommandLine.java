package com.researchspace.samples;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import com.researchspace.samples.model.Sample;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class SamplesCommandLine implements CommandLineRunner {

	@Autowired
	private SamplesAPI samplesAPI;
	
	@Autowired
	private ConsoleWriter writer;
	
	@Autowired
	private ConsoleReader reader;
	
	@Autowired 
	private ExitApp exitApp;
	

	
	@Override
	public void run(String... args) throws Exception {
		
		writer.println("Welcome to Samples Viewer");
		
		// Call get samples API
		SamplesResponse samplesResponse = null;
		try {
			samplesResponse = samplesAPI.getSamples();
		}catch(HttpClientErrorException ex){
			exitApp.exit(1, String.format("Error retrieving samples. Returned status code of %1$s", ex.getStatusCode()));
			return;
		}catch(Exception ex2) {
			exitApp.exit(1, String.format("Error retrieving samples %1$s", ex2.getMessage()));
			return;
		}

			
		writer.println(String.format("You have %1$s samples %n", samplesResponse.getTotalHits()));
		
		var view = reader.read("View sample details? (Y/N): ");
		
		if(!view.equalsIgnoreCase("y")) { 
			exitApp.exit(0,"Thank you for using sample viewer");
		}else {
			displaySamples(samplesResponse.getSamples());
		}

	}
	
	private void displaySamples(List<Sample> samples) {
		writer.println("");
		
		var format = "%-20s | %-15s | %-15s | %-20s %n";
		
		// Print table header
		writer.println(String.format(format, "Name", "Min Temp/°C", "Max Temp/°C", "Expiry Date"));
		
		// Print sample on each row
		for(Sample sample : samples) {
			writer.println(String.format(format,
				sample.getName(), 
				sample.getStorageTempMin() == null ? null : sample.getStorageTempMin().getNumericValue().longValue(), 
				sample.getStorageTempMax() == null ? null : sample.getStorageTempMax().getNumericValue().longValue(),
				sample.getExpiryDate()));	
		}
	}

}
