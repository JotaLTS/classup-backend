package com.tcc.classup.dto.aluno;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AlunoCreateDTO(

        @NotBlank
        @Size(max = 100)
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Size(max = 20)
        String matricula,

        @NotNull
        Long turmaId
) {
}
