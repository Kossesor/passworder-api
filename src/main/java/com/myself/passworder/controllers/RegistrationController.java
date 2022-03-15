package com.myself.passworder.controllers;

import com.myself.passworder.exeptions.UserEmailAlreadyExistException;
import com.myself.passworder.exeptions.UsernameAlreadyExistException;
import com.myself.passworder.models.User;
import com.myself.passworder.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class RegistrationController {
    private final UserService userService;

    @PostMapping("/registration")
    public int addUser(@RequestBody @Valid User user) {
        try {
            userService.addUser(user);
            return 0;
        } catch (UserEmailAlreadyExistException e) {
            return 1;
        } catch (UsernameAlreadyExistException e) {
            return 2;
        }
    }

    @GetMapping("/activation/{code}")
    public boolean activation(@PathVariable String code) {
        System.out.println(code);
        return userService.activateUser(code);
    }
    @GetMapping("/test")
    public User user() {
        return userService.getUserById(1L);
    }
}
