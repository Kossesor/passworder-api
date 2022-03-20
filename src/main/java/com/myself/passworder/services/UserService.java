package com.myself.passworder.services;

import com.myself.passworder.exeptions.UserEmailAlreadyExistException;
import com.myself.passworder.exeptions.UsernameAlreadyExistException;
import com.myself.passworder.models.Role;
import com.myself.passworder.models.User;
import com.myself.passworder.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final ValidationService validationService;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final MailSender mailSender;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findFirstById(id);
    }

    public void addUser(User user) throws UserEmailAlreadyExistException, UsernameAlreadyExistException {
        if (validationService.isUsernameExist(user.getUsername())) throw new UsernameAlreadyExistException();
        if (validationService.isEmailExist(user.getEmail())) throw new UserEmailAlreadyExistException();

        user.setRoles(Collections.singleton(user.getUsername().equals("admin") ? Role.ADMIN : Role.USER)); // fixme delete
        user.setActivationCode(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        saveUser(user);

        if (!user.getEmail().isEmpty()) {
            String massage = String.format(
                    "Hello, %s! \n Go here http://localhost:3000/activation/%s",
                    user.getUsername(),
                    user.getActivationCode()
            );
            mailSender.send(user.getEmail(), "Activation Code", massage);
        }
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User getUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) throw new UsernameNotFoundException("User not found");
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) throw new UsernameNotFoundException("User not found");
        return user;
    }

    public boolean  activateUser(String code) {
        User user = userRepository.findByActivationCode(code);
        if (user == null) return false;
        user.setActive(true);
        user.setActivationCode(null);
        userRepository.save(user);
        return true;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}