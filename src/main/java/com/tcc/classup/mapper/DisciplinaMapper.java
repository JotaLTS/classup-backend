package com.tcc.classup.mapper;

import com.tcc.classup.dto.disciplina.DisciplinaCreateDTO;
import com.tcc.classup.dto.disciplina.DisciplinaResponseDTO;
import com.tcc.classup.dto.disciplina.DisciplinaUpdateDTO;
import com.tcc.classup.model.Disciplina;
import com.tcc.classup.model.Professor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DisciplinaMapper {

    @Mapping(target = "professor", source = "professor")
    @Mapping(target = "nome",source = "disciplinaCreateDTO.nome")
    Disciplina toEntity(DisciplinaCreateDTO disciplinaCreateDTO, Professor professor);

    @Mapping(target = "professorId", source = "professor.id")
    @Mapping(target = "nomeProfessor", source = "professor.nome")
    DisciplinaResponseDTO toResponseDTO(Disciplina disciplina);

    void toUpdate(DisciplinaUpdateDTO disciplinaUpdateDTO, @MappingTarget Disciplina disciplina);

}
