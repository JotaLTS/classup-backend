package com.tcc.classup.dto.turma;

import com.tcc.classup.enums.TipoTurma;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record TurmaCreateDTO(

        @NotNull
        TipoTurma tipoTurma,

        @NotNull
        @Min(200)
        @Max(2100)
        Integer ano,


        @NotNull
        @Min(1)
        @Max(2)
        Integer semestre
) {
}
