package org.pk.springboot.rest.controller;

import org.pk.springboot.rest.exception.CityNotFoundException;
import org.pk.springboot.rest.other.Response;
import org.pk.springboot.rest.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cities")
public class CityController {

	@Autowired
	private CityService cityService;

	@RequestMapping(value = "/{stateId}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Response> findAllByStateId(@PathVariable("stateId") int stateId) {
		Response response = null;
		HttpStatus httpStatus = HttpStatus.OK;
		try {
			response = new Response(true, cityService.findByStateId(stateId), "");
		} catch (CityNotFoundException cne) {
			httpStatus = HttpStatus.NOT_FOUND;
			response = new Response(false, null, cne.getMessage());
		}
		return new ResponseEntity<>(response, httpStatus);
	}
}