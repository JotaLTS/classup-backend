package com.tcc.classup.dto.entregaAtividade;

import org.springframework.web.multipart.MultipartFile;

public record EntregaAtividadeReenvioDTO(

        String resposta,

        MultipartFile arquivo

) {
}
