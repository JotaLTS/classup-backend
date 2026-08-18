package com.tcc.classup.service.professor;


import com.tcc.classup.dto.professor.ProfessorCreateDTO;
import com.tcc.classup.dto.professor.ProfessorResponseDTO;
import com.tcc.classup.exception.RecursoJaCadastradoException;
import com.tcc.classup.exception.RecursoNaoEncontradoException;
import com.tcc.classup.mapper.ProfessorMapper;
import com.tcc.classup.model.Professor;
import com.tcc.classup.repository.ProfessorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ProfessorServiceImpl implements ProfessorService{

    private final ProfessorRepository professorRepository;
    private final ProfessorMapper professorMapper;
    private final PasswordEncoder passwordEncoder;

    public ProfessorServiceImpl(ProfessorRepository professorRepository, ProfessorMapper professorMapper, PasswordEncoder passwordEncoder) {
        this.professorRepository = professorRepository;
        this.professorMapper = professorMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ProfessorResponseDTO criar(ProfessorCreateDTO dto) {
        if(professorRepository.findByEmail(dto.email()).isPresent()){
            throw new RecursoJaCadastradoException("Email já cadastrado");
        }
        if(professorRepository.findByIdFuncional(dto.idFuncional()).isPresent()){
            throw new RecursoJaCadastradoException("Id Funcional já cadastrado");
        }

        Professor professor = professorMapper.toEntity(dto);
        professor.setSenha(passwordEncoder.encode("Mudar123"));
        Professor salvo = professorRepository.save(professor);

        return professorMapper.toResponseDTO(salvo);

    }

    @Override
    public ProfessorResponseDTO buscarPorId(Long id) {

        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Professor não encontrado com o id: " + id));
        return professorMapper.toResponseDTO(professor);
    }

    @Override
    public Page<ProfessorResponseDTO> listar(Pageable pageable) {

        Page<Professor> lista = professorRepository.findAll(pageable);
        return lista.map(professor -> professorMapper.toResponseDTO(professor));
    }
}
