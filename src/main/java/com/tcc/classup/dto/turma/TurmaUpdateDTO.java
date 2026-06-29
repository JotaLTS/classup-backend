package com.tcc.classup.dto.turma;

import com.tcc.classup.enums.TipoTurma;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record TurmaUpdateDTO(

        TipoTurma tipoTurma,

        @Min(2000)
        @Max(2100)
        Integer ano,

        @Min(1)
        @Max(2)
        Integer semestre
) {
}
