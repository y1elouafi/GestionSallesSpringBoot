package com.tenor.tsf.gs.exceptions;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class GSException extends Exception {

	private static final long serialVersionUID = 1L;

	public GSException(String message) {
		log.error("Project Gestion Salle: " + message);
	}
}
