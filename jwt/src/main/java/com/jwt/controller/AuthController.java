package com.jwt.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.utils.JwtUtils;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        if ("admin".equals(username) && "password".equals(password)) {
            return JwtUtils.generateToken(username);
        }
        throw new RuntimeException("Invalid credentials");
    }
}
