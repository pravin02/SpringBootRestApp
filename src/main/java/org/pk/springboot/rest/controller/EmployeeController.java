package org.pk.springboot.rest.controller;

import org.pk.springboot.rest.domian.UserRole;
import org.pk.springboot.rest.exception.EmployeeNotFoundException;
import org.pk.springboot.rest.other.Response;
import org.pk.springboot.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Response> findAllEmployees() {
		Response response = null;
		HttpStatus httpStatus = HttpStatus.OK;
		try {
			response = new Response(true, employeeService.findByUserRole(UserRole.EMPLOYEE.name()), "");
		} catch (EmployeeNotFoundException emnfe) {
			httpStatus = HttpStatus.NOT_FOUND;
			response = new Response(false, null, emnfe.getMessage());
		}
		return new ResponseEntity<Response>(response, httpStatus);
	}

	@RequestMapping(value = "/{employeeId}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Response> findOne(@PathVariable("employeeId") int employeeId) {
		Response response = null;
		HttpStatus httpStatus = HttpStatus.OK;
		try {
			response = new Response(true, employeeService.findByUserId(employeeId), "");
		} catch (EmployeeNotFoundException emnfe) {
			httpStatus = HttpStatus.NOT_FOUND;
			response = new Response(false, null, emnfe.getMessage());
		}
		return new ResponseEntity<Response>(response, httpStatus);
	}

}
