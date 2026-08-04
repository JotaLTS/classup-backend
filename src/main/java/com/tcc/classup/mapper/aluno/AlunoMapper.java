package com.tcc.classup.mapper.aluno;

import com.tcc.classup.dto.aluno.AlunoCreateDTO;
import com.tcc.classup.dto.aluno.AlunoResponseDTO;
import com.tcc.classup.dto.aluno.AlunoUpdateDTO;
import com.tcc.classup.dto.aluno.AlunoUpdateSenhaDTO;
import com.tcc.classup.model.Aluno;
import com.tcc.classup.model.Turma;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AlunoMapper {

    @Mapping(target = "turma",source = "turma")
    Aluno toEntity(AlunoCreateDTO alunoCreateDTO, Turma turma);

    @Mapping(target = "turmaId",source = "turma.id")
    @Mapping(target = "tipoTurma",source = "turma.tipoTurma")
    AlunoResponseDTO toResponseDTO(Aluno aluno);

    void toUpdate(AlunoUpdateDTO alunoUpdateDTO, @MappingTarget Aluno aluno);

    void toUpdateSenha(AlunoUpdateSenhaDTO alunoUpdateSenhaDTO, @MappingTarget Aluno aluno);

}
