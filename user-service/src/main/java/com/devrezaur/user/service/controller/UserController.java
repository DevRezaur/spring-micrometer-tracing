package com.devrezaur.user.service.controller;

import com.devrezaur.user.service.model.User;
import com.devrezaur.user.service.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> getAllUserInfo() {
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserInfo(@PathVariable UUID id) {
        User user;
        try {
            user = userService.findUserById(id);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
