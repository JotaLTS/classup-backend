package com.tcc.classup.mapper;

import com.tcc.classup.dto.atividade.AtividadeCreateDTO;
import com.tcc.classup.dto.atividade.AtividadeResponseDTO;
import com.tcc.classup.dto.atividade.AtividadeUpdateDTO;
import com.tcc.classup.model.Atividade;
import com.tcc.classup.model.Disciplina;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AtividadeMapper {

    @Mapping(target = "disciplina",source = "disciplina")
    Atividade toEntity(AtividadeCreateDTO atividadeCreateDTO, Disciplina disciplina);

    @Mapping(target = "nomeDisciplina",source = "disciplina.nome")
    @Mapping(target = "disciplinaId",source = "disciplina.id")
    AtividadeResponseDTO toResponseDTO(Atividade atividade);

    void toUpdate(AtividadeUpdateDTO atividadeUpdateDTO, @MappingTarget Atividade atividade);
}
