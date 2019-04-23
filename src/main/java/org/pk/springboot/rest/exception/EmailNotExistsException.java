package org.pk.springboot.rest.exception;

public class EmailNotExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public EmailNotExistsException(String message) {
		super(message);
	}
}
