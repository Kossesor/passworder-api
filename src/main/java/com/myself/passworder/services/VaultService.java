package com.myself.passworder.services;

import com.myself.passworder.repositories.VaultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VaultService {
    private final VaultRepository vaultRepository;

    public final String getVaultDataById(Long id) {
        return vaultRepository.getVaultById(id).getData();
    }
}