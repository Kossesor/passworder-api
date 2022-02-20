package com.myself.passworder.controllers;

import com.myself.passworder.models.Vault;
import com.myself.passworder.services.VaultService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vault")
public class VaultController {
    private final VaultService vaultService;

    @PostMapping
    public Boolean RefreshVault(@RequestBody @Valid Vault data) {
        return true;
    }

    @GetMapping("/{id}")
    public String SendVault(@PathVariable Long id) {
        return String.valueOf(vaultService.getVaultDataById(id));
    }
}