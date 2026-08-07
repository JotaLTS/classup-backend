package com.tcc.classup.service.turma;

import com.tcc.classup.dto.turma.TurmaCreateDTO;
import com.tcc.classup.dto.turma.TurmaResponseDTO;
import com.tcc.classup.exception.RecursoJaCadastradoException;
import com.tcc.classup.exception.RecursoNaoEncontradoException;
import com.tcc.classup.mapper.TurmaMapper;
import com.tcc.classup.model.Turma;
import com.tcc.classup.repository.TurmaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TurmaServiceImpl implements TurmaService{

    private final TurmaRepository turmaRepository;
    private final TurmaMapper turmaMapper;

    public TurmaServiceImpl(TurmaRepository turmaRepository, TurmaMapper turmaMapper) {
        this.turmaRepository = turmaRepository;
        this.turmaMapper = turmaMapper;
    }


    @Override
    public TurmaResponseDTO criar(TurmaCreateDTO dto) {
        if(turmaRepository.findByTipoTurmaAndAnoAndSemestre(dto.tipoTurma(),dto.ano(),dto.semestre()).isPresent()){
            throw new RecursoJaCadastradoException("Turma já cadastrada");
        }

        Turma turma = turmaMapper.toEntity(dto);

        Turma salvo = turmaRepository.save(turma);

        return turmaMapper.toResponseDTO(salvo);
    }

    @Override
    public TurmaResponseDTO buscarPorId(Long id) {

        Turma turma = turmaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Turma não encontrada com o id" + id));
        return turmaMapper.toResponseDTO(turma);
    }

    @Override
    public Page<TurmaResponseDTO> listar(Pageable pageable) {


        Page<Turma> lista = turmaRepository.findAll(pageable);
        return lista.map(turma -> turmaMapper.toResponseDTO(turma));
    }
}
