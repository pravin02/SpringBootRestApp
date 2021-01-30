package org.pk.springboot.rest.controller;

import org.pk.springboot.rest.domian.UserRole;
import org.pk.springboot.rest.exception.EmployeeNotFoundException;
import org.pk.springboot.rest.other.Response;
import org.pk.springboot.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public ResponseEntity<Response> findAllEmployees() {
		Response response = null;
		HttpStatus httpStatus = HttpStatus.OK;
		try {
			response = new Response(true, employeeService.findByUserRole(UserRole.EMPLOYEE.name()), "");
		} catch (EmployeeNotFoundException emnfe) {
			httpStatus = HttpStatus.NOT_FOUND;
			response = new Response(false, null, emnfe.getMessage());
		}
		return new ResponseEntity<>(response, httpStatus);
	}

	@GetMapping("/{employeeId}")
	public ResponseEntity<Response> findOne(@PathVariable("employeeId") int employeeId) {
		Response response = null;
		HttpStatus httpStatus = HttpStatus.OK;
		try {
			response = new Response(true, employeeService.findByUserId(employeeId), "");
		} catch (EmployeeNotFoundException emnfe) {
			httpStatus = HttpStatus.NOT_FOUND;
			response = new Response(false, null, emnfe.getMessage());
		}
		return new ResponseEntity<>(response, httpStatus);
	}

}
