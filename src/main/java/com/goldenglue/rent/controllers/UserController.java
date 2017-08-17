package com.goldenglue.rent.controllers;

import com.goldenglue.rent.entities.User;
import com.goldenglue.rent.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /*@PostMapping("/user")
    public String addNewUser(@RequestBody User user) {
        userService.addNewUser(user);
        return "User " + user.getUsername() + " added.";
    }*/

    @GetMapping("/nowiwanttofind/everyfuckinguser")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
