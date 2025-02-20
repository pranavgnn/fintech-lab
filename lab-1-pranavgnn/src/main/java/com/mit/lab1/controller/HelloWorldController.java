package com.mit.lab1.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/hello-world")
public class HelloWorldController {
    
    @GetMapping
    public String getHelloWorld () {
        return "Hello, World!";
    }
}
