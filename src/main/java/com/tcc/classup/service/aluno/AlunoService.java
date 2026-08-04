package com.tcc.classup.service.aluno;

import com.tcc.classup.dto.aluno.AlunoCreateDTO;
import com.tcc.classup.dto.aluno.AlunoResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AlunoService {

    AlunoResponseDTO criar(AlunoCreateDTO dto);

    AlunoResponseDTO buscarPorId(Long id);

    Page<AlunoResponseDTO> listar(Pageable pageable);

    Page<AlunoResponseDTO> listarPorTurma(Long turmaId,Pageable pageable);
}
