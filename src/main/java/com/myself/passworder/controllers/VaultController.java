package com.myself.passworder.controllers;

import com.myself.passworder.models.Vault;
import com.myself.passworder.services.VaultService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vaults")
public class VaultController {
    private final VaultService vaultService;

    @GetMapping("/{id}")
    public List<Vault> GetVaults(@PathVariable Long id) {
        return vaultService.getVaultDataByParentId(id);
    }

    @DeleteMapping("/{id}")
    public boolean DeleteVault(@PathVariable Long id) {
        return vaultService.deleteVaultData(id);
    }
    @PatchMapping("/update")
    public boolean SetVault(@RequestBody @Valid Vault vault) {
        System.out.println(vault);
        return vaultService.updateVaultData(vault);
    }

    @PostMapping("/create")
    public boolean CreateVault(@RequestBody Vault vault) {
        return vaultService.createVault(vault);
    }
}
