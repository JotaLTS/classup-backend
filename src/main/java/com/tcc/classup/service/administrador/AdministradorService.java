package com.tcc.classup.service.administrador;

import com.tcc.classup.dto.administrador.AdministradorCreateDTO;
import com.tcc.classup.dto.administrador.AdministradorResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdministradorService {

    AdministradorResponseDTO criar(AdministradorCreateDTO dto);

    AdministradorResponseDTO buscarPorId(Long id);

    Page<AdministradorResponseDTO> listar(Pageable pageable);

}
