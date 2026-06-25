package com.tcc.classup.dto.professor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProfessorCreateDTO(

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
