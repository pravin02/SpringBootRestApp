package org.pk.springboot.rest.controller;

import org.pk.springboot.rest.exception.StateNotFoundException;
import org.pk.springboot.rest.other.Response;
import org.pk.springboot.rest.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/states")
public class StateController {

	@Autowired
	private StateService stateService;

	@RequestMapping(value = "/{countryId}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Response> findByCountryId(@PathVariable("countryId") int countryId) {
		Response response = null;
		HttpStatus httpStatus = HttpStatus.OK;
		try {
			response = new Response(true, stateService.findByCountryId(countryId), "");
		} catch (StateNotFoundException snfe) {
			httpStatus = HttpStatus.NOT_FOUND;
			response = new Response(false, null, snfe.getMessage());			
		}
		return new ResponseEntity<Response>(response, httpStatus);
	}

}
