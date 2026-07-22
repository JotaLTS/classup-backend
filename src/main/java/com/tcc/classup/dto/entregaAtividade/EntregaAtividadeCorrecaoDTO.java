package com.tcc.classup.dto.entregaAtividade;

import jakarta.validation.constraints.*;

public record EntregaAtividadeCorrecaoDTO(

        @NotNull
        @DecimalMin("0.0")
        @DecimalMax("10.0")
        Double nota,

        @Size(max = 500)
        String feedback
) {
}
