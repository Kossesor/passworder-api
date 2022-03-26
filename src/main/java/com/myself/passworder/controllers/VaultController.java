package com.myself.passworder.controllers;

import com.myself.passworder.models.Vault;
import com.myself.passworder.services.VaultService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vaults")
public class VaultController {
    private final VaultService vaultService;

    @GetMapping("/{id}")
    public List<Vault> SendVault(@PathVariable Long id) {
        return vaultService.getVaultDataByParentId(id);
    }
}