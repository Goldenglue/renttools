package com.goldenglue.rent.controllers;

import com.goldenglue.rent.entities.Role;
import com.goldenglue.rent.entities.User;
import com.goldenglue.rent.pojos.UserRegistration;
import com.goldenglue.rent.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class HomeController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/registration")
    public String registration(@RequestBody UserRegistration userRegistration) {
        if (!userRegistration.getPassword().equals(userRegistration.getPasswordConfirmation())) {
            return "Passwords did not match";
        } else if (userService.getUser(userRegistration.getUsername()) != null) {
            return "User already exists";
        }

        userService.addNewUser(new User(userRegistration.getUsername(),userRegistration.getPassword(), Arrays.asList(new Role("USER"))));
        return "User created";
    }
}
