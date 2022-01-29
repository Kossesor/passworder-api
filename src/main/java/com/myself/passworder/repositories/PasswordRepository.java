package com.myself.passworder.repositories;

import com.myself.passworder.models.Password;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordRepository extends JpaRepository<Password, Long> {
    Password findFirstById(Long id);
    Password findByLogin(String email);
    Password findByTitle(String username);

    void deleteById(Long id);
}
