package com.myself.passworder.repositories;

import com.myself.passworder.models.Vault;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface VaultRepository extends JpaRepository<Vault, Long> {
    List<Vault> getVaultsByPid(Long id);

    List<Vault> getVaultsByTitle(String title);

}