package com.tcc.classup.dto.materialApoio;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

public record MaterialApoioUpdateDTO(

        @Size(max = 100)
        String titulo,

        @NotBlank
        String descricao,

        MultipartFile arquivo,

        String urlMaterial
) {
}
