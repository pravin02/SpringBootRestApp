package org.pk.springboot.rest.controller;

import org.pk.springboot.rest.dto.UserDto;
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
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Response> add(@RequestBody UserDto object) {
        Response response = null;
        HttpStatus httpStatus = HttpStatus.OK;
        object = new UserDto(userService.save(UserDto.toUserForSave(object)));
        response = new Response(true, object, "User updated successfully.");
        return new ResponseEntity<Response>(response, httpStatus);
    }
}