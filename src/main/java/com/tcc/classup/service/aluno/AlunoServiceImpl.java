package com.tcc.classup.service.aluno;

import com.tcc.classup.dto.aluno.AlunoCreateDTO;
import com.tcc.classup.dto.aluno.AlunoResponseDTO;
import com.tcc.classup.exception.RecursoJaCadastradoException;
import com.tcc.classup.exception.RecursoNaoEncontradoException;
import com.tcc.classup.mapper.AlunoMapper;
import com.tcc.classup.model.Aluno;
import com.tcc.classup.model.Turma;
import com.tcc.classup.repository.TurmaRepository;
import com.tcc.classup.repository.AlunoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AlunoServiceImpl implements AlunoService{

    private final AlunoRepository alunoRepository;
    private final AlunoMapper alunoMapper;
    private final TurmaRepository turmaRepository;
    private final PasswordEncoder passwordEncoder;

    public AlunoServiceImpl(AlunoRepository alunoRepository, AlunoMapper alunoMapper, TurmaRepository turmaRepository, PasswordEncoder passwordEncoder){
        this.alunoRepository = alunoRepository;
        this.alunoMapper = alunoMapper;
        this.turmaRepository = turmaRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AlunoResponseDTO criar(AlunoCreateDTO dto) {
        if(alunoRepository.findByEmail(dto.email()).isPresent()){
            throw new RecursoJaCadastradoException("Esse email já está cadastrado");
        }

        if(alunoRepository.findByMatricula(dto.matricula()).isPresent()){
            throw new RecursoJaCadastradoException("Essa matricula já está cadastrada");
        }

        Turma turma = turmaRepository.findById(dto.turmaId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Turma não encontrada"));

        Aluno aluno = alunoMapper.toEntity(dto,turma);
        aluno.setSenha(passwordEncoder.encode("Mudar123"));
        Aluno salvo = alunoRepository.save(aluno);

        return alunoMapper.toResponseDTO(salvo);

    }

    @Override
    public AlunoResponseDTO buscarPorId(Long id) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Aluno não encontrado com o id: " + id));
        return alunoMapper.toResponseDTO(aluno);
    }

    @Override
    public Page<AlunoResponseDTO> listar(Pageable pageable) {

        Page<Aluno> lista = alunoRepository.findAll(pageable);
        return lista.map(aluno -> alunoMapper.toResponseDTO(aluno));

    }

    @Override
    public Page<AlunoResponseDTO> listarPorTurma(Long turmaId, Pageable pageable) {
        if(!turmaRepository.existsById(turmaId)){
            throw new RecursoNaoEncontradoException("Turma não encontrada com o id: " + turmaId);
        }
        Page<Aluno> lista = alunoRepository.findByTurmaId(turmaId,pageable);
        return lista.map(aluno -> alunoMapper.toResponseDTO(aluno));
    }
}
