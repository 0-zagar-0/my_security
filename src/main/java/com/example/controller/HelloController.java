package com.example.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HelloController {
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello all ... ";
    }

    @GetMapping("/hi")
    public String sayHi() {
        return "Hi all ... ";
    }
}
