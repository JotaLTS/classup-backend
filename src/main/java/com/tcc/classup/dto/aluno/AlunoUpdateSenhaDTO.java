package com.tcc.classup.dto.aluno;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AlunoUpdateSenhaDTO(

        @NotBlank
        @Size(min = 8,max = 100)
        String senha

) {
}
