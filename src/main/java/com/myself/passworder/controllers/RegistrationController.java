package com.myself.passworder.controllers;

import com.google.common.collect.ImmutableMap;
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
    public ImmutableMap<String, Boolean> addUser(@RequestBody @Valid User user) {
        try {
            userService.addUser(user);
        } catch (UsernameAlreadyExistException e) {
            return ImmutableMap.of("UsernameAlreadyExist", true);
        } catch (UserEmailAlreadyExistException e) {
            return ImmutableMap.of("UserEmailAlreadyExist", true);
        }
        return ImmutableMap.of("UsernameAlreadyExist", false, "UserEmailAlreadyExist", false);
    }

    @GetMapping("/activation/{code}")
    public String activation(@PathVariable String code) {
        return userService.activateUser(code) ? "User successfully activated" : "Activation code is not found";
    }
}
