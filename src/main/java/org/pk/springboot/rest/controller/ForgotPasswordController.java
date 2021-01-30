package org.pk.springboot.rest.controller;

import org.pk.springboot.rest.domian.User;
import org.pk.springboot.rest.dto.UserDto;
import org.pk.springboot.rest.exception.EmailNotExistsException;
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

/**
 * @author Pravin P Patil
 */
@RestController
@RequestMapping("/api/forgot/password")
public class ForgotPasswordController {

    @Autowired
    private UserService userService;

    /**
     * @param user
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Response> forgotPassword(@RequestBody UserDto user) {
        Response response = null;
        HttpStatus httpStatus = HttpStatus.OK;
        User object = null;
        try {
            System.out.println(user);
            object = userService.findByEmail(user.getEmail());

            response = new Response(true, null, "Your password is : " + object.getPassword());
        } catch (EmailNotExistsException e) {
            e.printStackTrace();
            httpStatus = HttpStatus.NOT_FOUND;
            response = new Response(false, null, "Email not exists in database");
        }
        return new ResponseEntity<>(response, httpStatus);
    }
}