package com.tcc.classup.service.turma;

import com.tcc.classup.dto.turma.TurmaCreateDTO;
import com.tcc.classup.dto.turma.TurmaResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TurmaService {

    TurmaResponseDTO criar(TurmaCreateDTO dto);

    TurmaResponseDTO buscarPorId(Long id);

    Page<TurmaResponseDTO> listar(Pageable pageable);
}
