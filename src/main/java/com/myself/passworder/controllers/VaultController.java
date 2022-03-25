package com.myself.passworder.controllers;

import com.myself.passworder.services.VaultService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vault")
public class VaultController {
    private final VaultService vaultService;

    @GetMapping("/{id}")
    public String SendVault(@PathVariable Long id) {
        return vaultService.getVaultDataById(id);
    }

    @PostMapping("/create")
    public void CreateVault(String encryptedData) {

    }
}