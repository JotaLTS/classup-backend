package com.tcc.classup.dto.turma;

import com.tcc.classup.enums.TipoTurma;
public record TurmaResponseDTO(

        Long id,

        TipoTurma tipoTurma,

        Integer ano,

        Integer semestre
) {
}
