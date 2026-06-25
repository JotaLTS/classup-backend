package com.tcc.classup.dto.administrador;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AdministradorCreateDTO(

        @NotBlank
        @Size(max = 100)
        String nome,

        @NotBlank
        @Email
        String email,


        @NotBlank
        @Size(max = 20)
        String idFuncional
) {
}
