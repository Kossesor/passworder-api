package com.myself.passworder.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//    FIXME we need jrt
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    @NotNull
    @NotBlank
    String username;
    @NotNull
    @NotBlank
    String password;
}