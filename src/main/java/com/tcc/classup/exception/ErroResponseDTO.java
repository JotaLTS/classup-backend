package com.tcc.classup.exception;

import java.time.LocalDateTime;

public record ErroResponseDTO(
        Integer status,

        String mensagem,

        LocalDateTime timestamp
) {
}
