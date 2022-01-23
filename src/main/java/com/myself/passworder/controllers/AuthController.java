package com.myself.passworder.controllers;

import com.myself.passworder.models.User;
import com.myself.passworder.services.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    @PostMapping("/login")
    public Response login(@RequestBody @Valid LoginRequest form) {
        System.out.println(form);
        User user = userService.getUserByUsername(form.username);
        return new Response("aaa", "bbb");
    }

    @PostMapping("/refresh")
    public Response refresh() {
        return new Response("xxx", "yyy");
    }

    @GetMapping("/user")
    public Map user() {
        Map<String, Object> user = new HashMap<>();
        user.put("name", "vasya");
        user.put("admin", true);
        return user;
    }

    @PostMapping("/logout")
    public void logout() {
        System.out.println("logout");
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class LoginRequest {
        @NotBlank
        String username;
        @NotBlank
        String password;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Response {
        String access_token;
        String refresh_token;
    }
}