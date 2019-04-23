package org.pk.springboot.rest.exception;

public class CountryNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public CountryNotFoundException(String message) {
		super(message);
	}
}
