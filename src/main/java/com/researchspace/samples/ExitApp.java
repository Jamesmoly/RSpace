package com.researchspace.samples;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ExitApp {

	private static final String EXITING = "Exiting application";
	
	public void exit(int exitCode, String message ) {
		log.error(message);
		log.error(EXITING);
		System.exit(exitCode);
	}
}
