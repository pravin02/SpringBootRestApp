package org.pk.springboot.rest.controller;

import org.pk.springboot.rest.domian.User;
import org.pk.springboot.rest.dto.UserDto;
import org.pk.springboot.rest.exception.UserAlreadyExistsException;
import org.pk.springboot.rest.exception.UserNotFoundException;
import org.pk.springboot.rest.other.Response;
import org.pk.springboot.rest.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

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
        try {
            User user = userService.save(UserDto.toUserForSave(object));
            object = new UserDto(user);
            response = new Response(true, object, "User updated successfully.");
        } catch (UserAlreadyExistsException uaee) {
            response = new Response(false, null, uaee.getMessage());
        }
        return new ResponseEntity<>(response, httpStatus);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Response> update(@PathVariable Integer userId, @RequestBody UserDto object) {
        Response response = null;
        HttpStatus httpStatus = HttpStatus.OK;
        try {
            User user = userService.update(userId, UserDto.toUserForSave(object));
            object = new UserDto(user);
            response = new Response(true, object, "User updated successfully.");
        } catch (UserNotFoundException uaee) {
            response = new Response(false, null, uaee.getMessage());
        }
        return new ResponseEntity<>(response, httpStatus);
    }
}
