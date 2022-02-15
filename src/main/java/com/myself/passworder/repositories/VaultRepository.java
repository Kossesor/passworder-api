package com.myself.passworder.repositories;

import com.myself.passworder.models.Vault;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaultRepository extends JpaRepository<Vault, Long> {
    Vault getVaultById(Long id);
}