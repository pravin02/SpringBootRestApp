package org.pk.springboot.rest.controller;

import org.pk.springboot.rest.dto.UserDto;
import org.pk.springboot.rest.exception.LoginFailedException;
import org.pk.springboot.rest.other.Response;
import org.pk.springboot.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Pravin P Patil
 */
@RestController
@RequestMapping("/api/authentication")
public class AuthenticationController {

    @Autowired
    private UserService userService;

    /**
     * @param object
     * @return this API return response status if user details are valid then it
     * will return status true and data field will initialized with
     * user details.
     */

    @PostMapping
    public ResponseEntity<Response> add(@RequestBody UserDto object) {
        Response response = null;
        HttpStatus httpStatus = HttpStatus.OK;
        try {
            object = userService.findByEmailAndPassword(object.getEmail(), object.getPassword());
            response = new Response(true, object, "Logged in succesfully.");
        } catch (LoginFailedException lfe) {
            httpStatus = HttpStatus.NOT_FOUND;
            response = new Response(false, null, lfe.getMessage());
        }
        return new ResponseEntity<>(response, httpStatus);
    }
}