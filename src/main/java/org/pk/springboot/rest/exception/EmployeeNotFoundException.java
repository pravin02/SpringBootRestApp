package org.pk.springboot.rest.exception;

public class EmployeeNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundException(String message) {
		super(message);
	}
}
