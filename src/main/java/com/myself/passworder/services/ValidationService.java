package com.myself.passworder.services;

import com.myself.passworder.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ValidationService {
    private final UserRepository userRepository;

    public Boolean isUsernameExist(String username) {
        return userRepository.findByUsername(username) != null;
    }

    public Boolean isEmailExist(String email) {
        return userRepository.findByEmail(email) != null;
    }
}