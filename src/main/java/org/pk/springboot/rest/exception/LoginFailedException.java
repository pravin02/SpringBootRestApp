package org.pk.springboot.rest.exception;

public class LoginFailedException extends Exception {

	private static final long serialVersionUID = 1L;

	public LoginFailedException(String message) {
		super(message);
	}
}
