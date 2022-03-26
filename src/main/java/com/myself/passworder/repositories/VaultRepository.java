package com.myself.passworder.repositories;

import com.myself.passworder.models.Vault;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VaultRepository extends JpaRepository<Vault, Long> {
    List<Vault> getVaultsByPid(Long id);
}