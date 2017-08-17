package com.goldenglue.rent.controllers;

import com.goldenglue.rent.entities.Role;
import com.goldenglue.rent.entities.User;
import com.goldenglue.rent.pojos.UserRegistration;
import com.goldenglue.rent.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;

//TODO so for some reason none of the userpages get resolved even with thymeleaf added rip, resolve this shit
@Controller
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping(value = "/registration")
    public String registration(@RequestBody UserRegistration userRegistration) {
        if (!userRegistration.getPassword().equals(userRegistration.getPasswordConfirmation())) {
            return "Passwords did not match";
        } else if (userService.getUser(userRegistration.getUsername()) != null) {
            return "User already exists";
        }

        userService.addNewUser(new User(userRegistration.getUsername(), userRegistration.getPassword(), Arrays.asList(new Role("USER"))));
        return "User created";
    }
}
