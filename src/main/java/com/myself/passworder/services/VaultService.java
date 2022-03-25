package com.myself.passworder.services;

import com.myself.passworder.models.Vault;
import com.myself.passworder.repositories.VaultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VaultService {
    private final VaultRepository vaultRepository;

    public String getVaultDataById(Long id) {
        Vault vault = vaultRepository.getVaultById(id);

        return vault == null ? "" : vault.getData();
    }
}