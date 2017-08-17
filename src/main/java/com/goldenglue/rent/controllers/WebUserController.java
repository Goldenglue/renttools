package com.goldenglue.rent.controllers;

import com.goldenglue.rent.entities.WebUser;
import com.goldenglue.rent.services.WebUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class WebUserController {
    @Autowired
    private WebUserService userService;

    @PostMapping("/user")
    public String addNewUser(@RequestBody WebUser user) {
        userService.addNewUser(user);
        return "WebUser " + user.getUsername() + " added.";
    }
}
