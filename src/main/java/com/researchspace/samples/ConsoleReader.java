package com.researchspace.samples;

import java.io.Console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsoleReader {

	@Autowired 
	private Console c;

	
	public String read(String message) {
		return c.readLine(message);
	}
}
