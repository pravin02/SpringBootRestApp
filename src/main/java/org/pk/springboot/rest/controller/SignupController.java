package org.pk.springboot.rest.controller;

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
@RequestMapping("/api/signup")
public class SignupController {

    @Autowired
    private UserService userService;

    /**
     * @param object
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Response> add(@RequestBody UserDto object) {
        Response response = null;
        HttpStatus httpStatus = HttpStatus.OK;
        try {
            userService.findByEmail(object.getEmail());
            response = new Response(false, null, "Email exists in database");

        } catch (EmailNotExistsException e) {
            httpStatus = HttpStatus.NOT_FOUND;
            /**
             * converting dto to user for insertion using userService and converting again return value to Dto for response
             */
            object = new UserDto(userService.save(UserDto.toUserForSave(object)));
            response = new Response(true, object, "");
        }

        return new ResponseEntity<>(response, httpStatus);
    }
}