package org.pk.springboot.rest.controller;

import org.pk.springboot.rest.exception.StateNotFoundException;
import org.pk.springboot.rest.other.Response;
import org.pk.springboot.rest.service.StateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/states")
public class StateController {

    @Autowired
    private StateService stateService;

    @GetMapping("/{countryId}")
    public ResponseEntity<Response> findByCountryId(@PathVariable("countryId") int countryId) {
        Response response = null;
        HttpStatus httpStatus = HttpStatus.OK;
        try {
            response = new Response(true, stateService.findByCountryId(countryId), "");
        } catch (StateNotFoundException snfe) {
            httpStatus = HttpStatus.NOT_FOUND;
            response = new Response(false, null, snfe.getMessage());
        }
        return new ResponseEntity<>(response, httpStatus);
    }

}
