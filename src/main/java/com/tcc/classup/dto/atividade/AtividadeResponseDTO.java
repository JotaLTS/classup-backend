package com.tcc.classup.dto.atividade;

import com.tcc.classup.enums.TipoAtividade;

import java.time.LocalDateTime;

public record AtividadeResponseDTO(

        Long id,

        String titulo,

        String descricao,

        TipoAtividade tipoAtividade,

        Double valor,

        LocalDateTime prazoEntrega,

        String disciplina
) {
}
