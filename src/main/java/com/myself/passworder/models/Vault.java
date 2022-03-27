package com.myself.passworder.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Builder
@Table(name = "vault")
@NoArgsConstructor
@AllArgsConstructor
public class Vault {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private Long pid;

    @NotNull
    @Size(min = 3)
    @Column(nullable = false)
    private String title;

    @NotNull
    @Size(min = 3, max = 50)
    @Column(length = 50, nullable = false, columnDefinition = "text")
    private String encryptedData;
}
