package com.tcc.classup.dto.conquista;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ConquistaUpdateDTO(

        @Size(max = 100)
        String titulo,

        @NotBlank
        String descricao,

        @Min(0)
        @Max(20)
        Integer pontuacaoMinima,

        String urlImagem

) {
}
