package com.goldenglue.rent.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Hello";
    }

    @GetMapping("/private")
    public String privateArea() {
        return "Private";
    }
}
