package com.tcc.classup.dto.entregaAtividade;

import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

public record EntregaAtividadeCreateDTO(

        String resposta,

        MultipartFile arquivo,

        @NotNull
        Long atividadeId

) {
}