package com.tcc.classup.service.disciplina;

import com.tcc.classup.dto.disciplina.DisciplinaCreateDTO;
import com.tcc.classup.dto.disciplina.DisciplinaResponseDTO;
import com.tcc.classup.exception.RecursoJaCadastradoException;
import com.tcc.classup.exception.RecursoNaoEncontradoException;
import com.tcc.classup.mapper.DisciplinaMapper;
import com.tcc.classup.model.Disciplina;
import com.tcc.classup.model.Professor;
import com.tcc.classup.repository.DisciplinaRepository;
import com.tcc.classup.repository.ProfessorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DisciplinaServiceImpl implements DisciplinaService{

    private final DisciplinaRepository disciplinaRepository;
    private final DisciplinaMapper disciplinaMapper;
    private final ProfessorRepository professorRepository;

    public DisciplinaServiceImpl(DisciplinaRepository disciplinaRepository, DisciplinaMapper disciplinaMapper, ProfessorRepository professorRepository) {
        this.disciplinaRepository = disciplinaRepository;
        this.disciplinaMapper = disciplinaMapper;
        this.professorRepository = professorRepository;
    }

    @Override
    public DisciplinaResponseDTO criar(DisciplinaCreateDTO dto) {
        if(disciplinaRepository.findByNome(dto.nome()).isPresent()){
            throw new RecursoJaCadastradoException("Disciplina já cadastrada");
        }

        Professor professor = null;

        if(dto.professorId() != null){
            professor = professorRepository.findById(dto.professorId())
                    .orElseThrow(() -> new RecursoNaoEncontradoException("Professor não encontrado"));
        }

        Disciplina disciplina = disciplinaMapper.toEntity(dto,professor);

        Disciplina salvo = disciplinaRepository.save(disciplina);

        return disciplinaMapper.toResponseDTO(salvo);
    }

    @Override
    public DisciplinaResponseDTO buscarPorId(Long id) {
        Disciplina disciplina = disciplinaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Disciplina não encontrado com o Id: " + id));
        return disciplinaMapper.toResponseDTO(disciplina);
    }

    @Override
    public Page<DisciplinaResponseDTO> listar(Pageable pageable) {

        Page<Disciplina> lista = disciplinaRepository.findAll(pageable);
        return lista.map(disciplina -> disciplinaMapper.toResponseDTO(disciplina));
    }
}
