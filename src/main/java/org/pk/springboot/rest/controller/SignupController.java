package org.pk.springboot.rest.controller;

import org.pk.springboot.rest.domian.User;
import org.pk.springboot.rest.exception.EmailExistsException;
import org.pk.springboot.rest.other.Response;
import org.pk.springboot.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/signup")
public class SignupController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Response> add(@RequestBody User object) {
		Response response = null;
		HttpStatus httpStatus = HttpStatus.OK;
		try {
			userService.findByEmail(object.getEmail());
			object = userService.save(object);
			response = new Response(true, object, "");
		} catch (EmailExistsException enfe) {
			httpStatus = HttpStatus.NOT_FOUND;
			response = new Response(false, null, "Email exists in database");
		}

		return new ResponseEntity<Response>(response, httpStatus);
	}
}