package com.tcc.classup.dto.aluno;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record AlunoUpdateDTO(

        @Size(max = 100)
        String nome,

        @Email
        String email,

        Long turmaId) {
}
