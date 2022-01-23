package com.myself.passworder.repositories;

import com.myself.passworder.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
    User findFirstById(Long id);
    User findByActivationCode(String code);

    void deleteById(Long id);

    @Query("SELECT a FROM User a WHERE a.username like %:keyword%")
    List<User> findAllByUsernameQuery(@Param("keyword") String keyword);
}
