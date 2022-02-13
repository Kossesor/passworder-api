package com.myself.passworder.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Blob;

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
    @Size(min = 3, max = 50)
    @Column(length = 50, nullable = false)
    private String name;

    @Lob
    @NotNull
    @Size(min = 3, max = 50)
    @Column(length = 50, nullable = false)
    private Blob data;
}