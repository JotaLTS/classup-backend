package com.tcc.classup.mapper.administrador;

import com.tcc.classup.dto.administrador.AdministradorCreateDTO;
import com.tcc.classup.dto.administrador.AdministradorResponseDTO;
import com.tcc.classup.dto.administrador.AdministradorUpdateDTO;
import com.tcc.classup.dto.administrador.AdministradorUpdateSenhaDTO;
import com.tcc.classup.model.Administrador;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AdministradorMapper {

    Administrador toEntity(AdministradorCreateDTO administradorCreateDTO);

    AdministradorResponseDTO toResponseDTO(Administrador administrador);

    void toUpdate(AdministradorUpdateDTO administradorUpdateDTO, @MappingTarget Administrador administrador);

    void toUpdateSenha(AdministradorUpdateSenhaDTO administradorUpdateSenhaDTO, @MappingTarget Administrador administrador);
}
