package com.tcc.classup.service.disciplina;

import com.tcc.classup.dto.disciplina.DisciplinaCreateDTO;
import com.tcc.classup.dto.disciplina.DisciplinaResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DisciplinaService {

    DisciplinaResponseDTO criar(DisciplinaCreateDTO dto);

    DisciplinaResponseDTO buscarPorId(Long id);

    Page<DisciplinaResponseDTO> listar(Pageable pageable);

}
