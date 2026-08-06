package com.tcc.classup.mapper;

import com.tcc.classup.dto.professor.ProfessorCreateDTO;
import com.tcc.classup.dto.professor.ProfessorResponseDTO;
import com.tcc.classup.dto.professor.ProfessorUpdateDTO;
import com.tcc.classup.dto.professor.ProfessorUpdateSenhaDTO;
import com.tcc.classup.model.Professor;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProfessorMapper {

    Professor toEntity(ProfessorCreateDTO professorCreateDTO);

    ProfessorResponseDTO toResponseDTO(Professor professor);

    void toUpdate(ProfessorUpdateDTO professorUpdateDTO, @MappingTarget Professor professor);

    void toUpdateSenha(ProfessorUpdateSenhaDTO professorUpdateSenhaDTO, @MappingTarget Professor professor);
}
