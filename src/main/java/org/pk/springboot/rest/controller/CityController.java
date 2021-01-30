package org.pk.springboot.rest.controller;

import org.pk.springboot.rest.exception.CityNotFoundException;
import org.pk.springboot.rest.other.Response;
import org.pk.springboot.rest.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Pravin P Patil
 */
@RestController
@RequestMapping("/api/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping(value = "/{stateId}")
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