package org.pk.springboot.rest.controller;

import org.pk.springboot.rest.exception.CountryNotFoundException;
import org.pk.springboot.rest.other.Response;
import org.pk.springboot.rest.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public ResponseEntity<Response> findAll() {
        Response response = null;
        HttpStatus httpStatus = HttpStatus.OK;
        try {
            response = new Response(true, countryService.findAll(), "");
        } catch (CountryNotFoundException cnfe) {
            response = new Response(false, null, cnfe.getMessage());
        }
        return new ResponseEntity<>(response, httpStatus);
    }
    
}
