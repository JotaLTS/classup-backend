package com.tcc.classup.dto.disciplina;

import com.tcc.classup.enums.TipoTurma;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DisciplinaCreateDTO(

        @NotBlank
        @Size(max = 100)
        String nome,

        @NotNull
        TipoTurma tipoTurma,

        @NotNull
        Long professorId
) {
}
