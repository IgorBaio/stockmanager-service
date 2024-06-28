package com.stockmanager.stockmanager.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public record UserRequestDTO(

        @NotBlank
        @NotNull
        @Size(min = 3, message = "Minimum size of 3")
        String name,

        @NotBlank
        @NotNull
        @Email
        String email,

        @NotNull(message = "A senha não pode ser nula.")
        // @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,20}$",
        //         message = "A senha deve ter entre 6 e 20 caracteres, incluindo letras maiúsculas, minúsculas, números e caracteres especiais.")
        String password,

        @NotBlank
        @NotNull
        String accessLvl
) {
}