package com.tcc.classup.dto.conquista;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ConquistaCreateDTO(

        @NotBlank
        @Size(max = 100)
        String titulo,

        @NotBlank
        String descricao,

        @NotNull
        @Min(0)
        @Min(20)
        Integer pontuacaoMinima,

        @NotBlank
        String urlImagem,

        @NotNull
        Long disciplinaId
) {
}
