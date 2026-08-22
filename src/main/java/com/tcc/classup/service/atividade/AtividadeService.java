package com.tcc.classup.service.atividade;

import com.tcc.classup.dto.atividade.AtividadeCreateDTO;
import com.tcc.classup.dto.atividade.AtividadeResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AtividadeService {

    AtividadeResponseDTO criar(AtividadeCreateDTO dto);

    AtividadeResponseDTO buscarPorId(Long id);

    Page<AtividadeResponseDTO> listar(Pageable pageable);

    Page<AtividadeResponseDTO> listarPorDisciplina(Long disciplinaId, Pageable pageable);

}
