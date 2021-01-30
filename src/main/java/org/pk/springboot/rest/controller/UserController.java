package org.pk.springboot.rest.controller;

import org.pk.springboot.rest.dto.UserDto;
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
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Response> add(@RequestBody UserDto object) {
        Response response = null;
        HttpStatus httpStatus = HttpStatus.OK;
        object = new UserDto(userService.save(UserDto.toUserForSave(object)));
        response = new Response(true, object, "User updated successfully.");
        return new ResponseEntity<>(response, httpStatus);
    }
}