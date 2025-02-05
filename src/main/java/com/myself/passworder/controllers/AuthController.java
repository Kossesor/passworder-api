package com.myself.passworder.controllers;

import com.myself.passworder.models.User;
import com.myself.passworder.requests.LoginRequest;
import com.myself.passworder.requests.LoginResponse;
import com.myself.passworder.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    @PostMapping("/login")
    public UserDetails login(@RequestBody @Valid LoginRequest form) {
        return userService.loadUserByUsername(form.getLogin());
    }

    @PostMapping("/refresh")
    public LoginResponse refresh() {
        return new LoginResponse("xxx", "yyy");
    }

    @GetMapping("/user")
    public User user() {
        return userService.getUserById(1L);
    }

    @GetMapping("/session")
    public String session() {
        return "token";
    }

    @PostMapping("/logout")
    public void logout() {
        System.out.println("logout");
    }
}