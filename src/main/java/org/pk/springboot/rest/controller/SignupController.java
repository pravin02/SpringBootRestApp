package org.pk.springboot.rest.controller;

import org.pk.springboot.rest.dto.UserDto;
import org.pk.springboot.rest.exception.EmailNotExistsException;
import org.pk.springboot.rest.exception.UserAlreadyExistsException;
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
@RequestMapping("/api/signup")
public class SignupController {

    @Autowired
    private UserService userService;

    /**
     * @param object
     * @return
     */
    @PostMapping
    public ResponseEntity<Response> add(@RequestBody UserDto object) {
        Response response = null;
        HttpStatus httpStatus = HttpStatus.OK;
        try {
            userService.findByEmail(object.getEmail());
            response = new Response(false, null, "Email exists in database");

        } catch (EmailNotExistsException e) {
            httpStatus = HttpStatus.NOT_FOUND;
            try {
                /**
                 * converting dto to user for insertion using userService and converting again return value to Dto for response
                 */
                object = new UserDto(userService.save(UserDto.toUserForSave(object)));
                response = new Response(true, object, "User registered successfully.");
            } catch (UserAlreadyExistsException uaee) {
                response = new Response(false, null, uaee.getMessage());
            }
        }
        return new ResponseEntity<>(response, httpStatus);
    }
}
