package com.myself.passworder.controllers;

import com.myself.passworder.requests.LoginRequest;
import com.myself.passworder.requests.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Valid LoginRequest form) {
        System.out.println(form);
        return new LoginResponse("aaa", "bbb");
    }

    @PostMapping("/refresh")
    public LoginResponse refresh() {
        return new LoginResponse("xxx", "yyy");
    }

    @GetMapping("/user")
    public Map<String, Object> user() {
        Map<String, Object> user = new HashMap<>();
        user.put("name", "vasya");
        user.put("admin", true);
        return user;
    }

    @PostMapping("/logout")
    public void logout() {
        System.out.println("logout");
    }
}