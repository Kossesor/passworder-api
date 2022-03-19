package com.myself.passworder.controllers;

import com.myself.passworder.exeptions.UserEmailAlreadyExistException;
import com.myself.passworder.exeptions.UsernameAlreadyExistException;
import com.myself.passworder.models.User;
import com.myself.passworder.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RegistrationController {
    private final UserService userService;

    @PostMapping("/registration")
    public List<Integer> addUser(@RequestBody @Valid User user) {
        // TODO handle 2 errors at time (add task to jira)
        List<Integer> errorCodes = new ArrayList<>(2);
        try {
            userService.addUser(user);
            errorCodes.add(0);
        } catch (UsernameAlreadyExistException e) {
            errorCodes.add(1);
        } catch (UserEmailAlreadyExistException e) {
            errorCodes.add(2);
        }
        return errorCodes;
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
