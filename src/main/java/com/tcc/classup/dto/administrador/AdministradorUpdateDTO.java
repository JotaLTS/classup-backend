package com.tcc.classup.dto.administrador;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record AdministradorUpdateDTO(

        @Size(max = 100)
        String nome,

        @Email
        String email
) {
}
