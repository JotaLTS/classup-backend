package com.tcc.classup.dto.conquista;

public record ConquistaResponseDTO(

        Long id,

        String titulo,

        String descricao,

        Integer pontuacaoMinima,

        String urlImagem,

        String disciplina
) {
}
