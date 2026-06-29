package com.tcc.classup.dto.professor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProfessorUpdateSenhaDTO(

        @NotBlank
        @Size(min = 8,max = 100)
        String senha

) {
}
