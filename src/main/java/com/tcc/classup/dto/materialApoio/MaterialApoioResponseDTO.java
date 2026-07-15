package com.tcc.classup.dto.materialApoio;

import java.time.LocalDateTime;

public record MaterialApoioResponseDTO(

        Long id,

        String titulo,

        String descricao,

        String nomeArquivo,

        String urlMaterial,

        LocalDateTime dataCriacao,

        String disciplina
) {
}
