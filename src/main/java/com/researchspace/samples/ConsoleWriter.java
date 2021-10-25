package com.researchspace.samples;

import java.io.Console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsoleWriter {

	@Autowired 
	private Console c;

	
	public void println(String line) {
		c.writer().println(line);
	}
}
