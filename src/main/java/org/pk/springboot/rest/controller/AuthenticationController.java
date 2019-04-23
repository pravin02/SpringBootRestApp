package org.pk.springboot.rest.controller;

import org.pk.springboot.rest.domian.User;
import org.pk.springboot.rest.exception.LoginFailedException;
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
@RequestMapping("/api/authentication")
public class AuthenticationController {

	@Autowired
	private UserService userService;

	/**
	 * @param User
	 *            object
	 * @return this API return response status if user details are valid then it
	 *         will return status true and data field will initialized with
	 *         user details.
	 */
	@RequestMapping(value = "", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Response> add(@RequestBody User object) {
		Response response = null;
		HttpStatus httpStatus = HttpStatus.OK;
		try {
			object = userService.findByEmailAndPassword(object.getEmail(), object.getPassword());
			response = new Response(true, object, "");
		} catch (LoginFailedException lfe) {
			httpStatus = HttpStatus.NOT_FOUND;
			response = new Response(false, null, lfe.getMessage());
		}
		return new ResponseEntity<Response>(response, httpStatus);
	}
}