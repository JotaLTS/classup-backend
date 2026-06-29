package com.tcc.classup.dto.professor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record ProfessorUpdateDTO(

        @Size(max = 100)
        String nome,

        @Email
        String email
) {
}
