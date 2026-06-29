package com.tcc.classup.dto.atividade;

import com.tcc.classup.enums.TipoAtividade;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public record AtividadeCreateDTO(

        @NotBlank
        @Size(max = 100)
        String titulo,

        @NotBlank
        String descricao,

        @NotNull
        TipoAtividade tipoAtividade,

        @NotNull
        @DecimalMin("0.0")
        @DecimalMax("10.0")
        Double valor,

        @NotNull
        LocalDateTime prazoEntrega,

        @NotNull
        Long disciplinaId
) {
}
