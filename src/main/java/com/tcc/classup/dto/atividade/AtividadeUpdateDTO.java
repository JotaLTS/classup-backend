package com.tcc.classup.dto.atividade;

import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public record AtividadeUpdateDTO(

        @Size(max = 100)
        String titulo,

        @NotBlank
        String descricao,

        @DecimalMin("0.0")
        @DecimalMax("10.0")
        Double valor,

        LocalDateTime prazoEntrega
) {
}
