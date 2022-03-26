package com.myself.passworder.services;

import com.myself.passworder.models.Vault;
import com.myself.passworder.repositories.VaultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VaultService {
    private final VaultRepository vaultRepository;

    public List<Vault> getVaultDataByParentId(Long id) {
        return vaultRepository.getVaultsByPid(id);
    }
}