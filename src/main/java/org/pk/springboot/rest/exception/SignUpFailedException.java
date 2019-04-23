package org.pk.springboot.rest.exception;

public class SignUpFailedException extends Exception {

	private static final long serialVersionUID = 1L;

	public SignUpFailedException(String message) {
		super(message);
	}
}
