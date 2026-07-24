package com.tcc.classup.dto.alunoConquista;

import java.time.LocalDateTime;

public record AlunoConquistaResponseDTO(

        Long id,

        String titulo,

        String descricao,

        String urlImagem,

        LocalDateTime dataDesbloqueio


) {
}
