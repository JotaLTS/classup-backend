package com.tcc.classup.mapper;

import com.tcc.classup.dto.turma.TurmaCreateDTO;
import com.tcc.classup.dto.turma.TurmaResponseDTO;
import com.tcc.classup.dto.turma.TurmaUpdateDTO;
import com.tcc.classup.model.Turma;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TurmaMapper {

    Turma toEntity(TurmaCreateDTO turmaCreateDTO);

    TurmaResponseDTO toResponseDTO(Turma turma);

    void toUpdate(TurmaUpdateDTO turmaUpdateDTO, @MappingTarget Turma turma);
}
