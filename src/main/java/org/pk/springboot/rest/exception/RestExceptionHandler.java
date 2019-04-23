package org.pk.springboot.rest.exception;

import org.pk.springboot.rest.other.Response;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			org.springframework.http.HttpHeaders headers, HttpStatus status, WebRequest request) {
		System.out.println("handleHttpMessageNotReadable");
		Response response = new Response(false, HttpStatus.BAD_REQUEST.name(), ex.getMessage());
		return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		System.out.println("handleHttpMediaTypeNotAcceptable");
		Response response = new Response(false, HttpStatus.NOT_ACCEPTABLE.name(), ex.getMessage());
		return new ResponseEntity<Object>(response, HttpStatus.NOT_ACCEPTABLE);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		System.out.println("handleHttpMediaTypeNotSupported");
		Response response = new Response(false, HttpStatus.UNSUPPORTED_MEDIA_TYPE.name(), ex.getMessage());
		return new ResponseEntity<Object>(response, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		System.out.println("handleHttpRequestMethodNotSupported");
		Response response = new Response(false, HttpStatus.METHOD_NOT_ALLOWED.name(), ex.getMessage());
		return new ResponseEntity<Object>(response, HttpStatus.METHOD_NOT_ALLOWED);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		System.out.println("handleMissingPathVariable");
		Response response = new Response(false, HttpStatus.METHOD_NOT_ALLOWED.name(), ex.getMessage());
		return new ResponseEntity<Object>(response, HttpStatus.METHOD_NOT_ALLOWED);
	}

	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		System.out.println("handleNoHandlerFoundException");
		Response response = new Response(false, HttpStatus.INTERNAL_SERVER_ERROR.name(), ex.getMessage());
		return new ResponseEntity<Object>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		System.out.println("handleExceptionInternal");
		Response response = new Response(false, HttpStatus.INTERNAL_SERVER_ERROR.name(), ex.getMessage());
		return new ResponseEntity<Object>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/*
	 * private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
	 * return new ResponseEntity<>(apiError, apiError.getStatus()); }
	 */
}