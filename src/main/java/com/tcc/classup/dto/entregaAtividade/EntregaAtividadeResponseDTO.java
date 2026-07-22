package com.tcc.classup.dto.entregaAtividade;

import com.tcc.classup.enums.StatusEntrega;

import java.time.LocalDateTime;

public record EntregaAtividadeResponseDTO(

        Long id,

        String resposta,

        String arquivoUrl,

        Double nota,

        StatusEntrega status,

        String feedack,

        LocalDateTime dataEntrega,

        LocalDateTime dataCorrecao

) {
}