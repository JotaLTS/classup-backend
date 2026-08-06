package com.tcc.classup.service.administrador;

import com.tcc.classup.dto.administrador.AdministradorCreateDTO;
import com.tcc.classup.dto.administrador.AdministradorResponseDTO;
import com.tcc.classup.exception.RecursoNaoEncontradoException;
import com.tcc.classup.exception.RecursoJaCadastradoException;
import com.tcc.classup.mapper.AdministradorMapper;
import com.tcc.classup.model.Administrador;
import com.tcc.classup.repository.AdministradorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AdministradorServiceImpl implements  AdministradorService{

    private final AdministradorRepository administradorRepository;
    private final AdministradorMapper administradorMapper;

    public AdministradorServiceImpl(AdministradorRepository administradorRepository, AdministradorMapper administradorMapper) {
        this.administradorRepository = administradorRepository;
        this.administradorMapper = administradorMapper;
    }

    @Override
    public AdministradorResponseDTO criar(AdministradorCreateDTO dto) {

        if(administradorRepository.findByEmail(dto.email()).isPresent()){
            throw new RecursoJaCadastradoException("Email já cadastrado");
        }

        if(administradorRepository.findByIdFuncional(dto.idFuncional()).isPresent()){
            throw new RecursoJaCadastradoException("Id Funcional já cadastrado");
        }

        Administrador administrador = administradorMapper.toEntity(dto);

        Administrador salvo = administradorRepository.save(administrador);

        return administradorMapper.toResponseDTO(salvo);

    }

    @Override
    public AdministradorResponseDTO buscarPorId(Long id) {

        Administrador administrador = administradorRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Administrador não encontrado com o id: " + id));
        return administradorMapper.toResponseDTO(administrador);

    }

    @Override
    public Page<AdministradorResponseDTO> listar(Pageable pageable) {

        Page<Administrador> lista = administradorRepository.findAll(pageable);
        return lista.map(administrador -> administradorMapper.toResponseDTO(administrador));

    }
}
