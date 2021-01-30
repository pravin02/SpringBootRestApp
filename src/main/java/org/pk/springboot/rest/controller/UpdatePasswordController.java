package org.pk.springboot.rest.controller;

import org.pk.springboot.rest.domian.User;
import org.pk.springboot.rest.domian.UserModel;
import org.pk.springboot.rest.exception.UserNotFoundException;
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
@RequestMapping("/api/update/password")
public class UpdatePasswordController {

    @Autowired
    private UserService userService;

    /**
     * @param user
     * @return
     */
    @PostMapping
    public ResponseEntity<Response> add(@RequestBody UserModel user) {
        Response response = null;
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        User object;
        try {
            object = userService.findByUserId(user.getUserId());

            if (!object.getPassword().equals(user.getPassword())) {
                response = new Response(false, null, "Invalid Old Password.");
            } else {
                if (!user.getConfirmPassword().equals(user.getNewPassword())) {
                    response = new Response(false, null, "New password & confirm password must be same.");
                } else {
                    if (userService.updatePassword(user.getUserId(), user.getNewPassword())) {
                        httpStatus = HttpStatus.OK;
                        response = new Response(true, null, "Password Updated Successfully.");
                    } else
                        response = new Response(true, null, "Error While updating Password.");
                }
            }
        } catch (UserNotFoundException e) {
            response = new Response(false, null, "New password & confirm password must be same.");
        }
        return new ResponseEntity<>(response, httpStatus);
    }
}