package org.pk.springboot.rest.exception;

public class StateNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public StateNotFoundException(String message) {
		super(message);
	}
}
