package com.tenor.tsf.gs.exceptions.function;

import com.tenor.tsf.gs.exceptions.GSException;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ElementNotFoundException extends  GSException{
 
	private static final long serialVersionUID = 1L;

	public ElementNotFoundException(String message) {
		super("Fonctionnel => "+message);
	}

}
