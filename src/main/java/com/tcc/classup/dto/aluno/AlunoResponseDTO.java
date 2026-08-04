package com.tcc.classup.dto.aluno;

import com.tcc.classup.enums.TipoTurma;

public record AlunoResponseDTO(

        Long id,

        String nome,

        String email,

        String matricula,

        Long turmaId,

        TipoTurma tipoTurma

) {
}
