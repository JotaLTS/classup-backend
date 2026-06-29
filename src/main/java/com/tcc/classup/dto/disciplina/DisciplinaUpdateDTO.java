package com.tcc.classup.dto.disciplina;

import com.tcc.classup.enums.TipoTurma;
import jakarta.validation.constraints.Size;

public record DisciplinaUpdateDTO(

        @Size(max = 100)
        String nome,

        TipoTurma tipoTurma,

        Long professorId
) {
}
