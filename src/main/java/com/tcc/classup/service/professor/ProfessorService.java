package com.tcc.classup.service.professor;


import com.tcc.classup.dto.professor.ProfessorCreateDTO;
import com.tcc.classup.dto.professor.ProfessorResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProfessorService {

    ProfessorResponseDTO criar(ProfessorCreateDTO dto);

    ProfessorResponseDTO buscarPorId(Long id);

    Page<ProfessorResponseDTO> listar(Pageable pageable);

}
