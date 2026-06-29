package com.tcc.classup.dto.aluno;

public record AlunoResponseDTO(

        Long id,

        String nome,

        String email,

        String matricula,

        String turma
) {
}
