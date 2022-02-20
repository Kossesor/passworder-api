package com.myself.passworder.services;

import com.myself.passworder.repositories.VaultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Blob;

@Service
@RequiredArgsConstructor
public class VaultService {
    private final VaultRepository vaultRepository;

    public final @NotNull @Size(min = 3, max = 50) Blob getVaultDataById(Long id) {
        return vaultRepository.getVaultById(id).getData();
    }
}