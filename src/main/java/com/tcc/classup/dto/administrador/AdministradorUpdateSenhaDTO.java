package com.tcc.classup.dto.administrador;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AdministradorUpdateSenhaDTO(

        @NotBlank
        @Size(min = 8,max = 100)
        String senha
) {
}
