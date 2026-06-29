package com.tcc.classup.dto.disciplina;

import com.tcc.classup.enums.TipoTurma;

public record DisciplinaResponseDTO(

        Long id,

        String nome,

        TipoTurma tipoTurma,

        String professor
) {
}
