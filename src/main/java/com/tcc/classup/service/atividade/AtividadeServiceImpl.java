package com.tcc.classup.service.atividade;

import com.tcc.classup.dto.atividade.AtividadeCreateDTO;
import com.tcc.classup.dto.atividade.AtividadeResponseDTO;
import com.tcc.classup.exception.RecursoJaCadastradoException;
import com.tcc.classup.exception.RecursoNaoEncontradoException;
import com.tcc.classup.mapper.AtividadeMapper;
import com.tcc.classup.model.Atividade;
import com.tcc.classup.model.Disciplina;
import com.tcc.classup.repository.AtividadeRepository;
import com.tcc.classup.repository.DisciplinaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AtividadeServiceImpl implements AtividadeService{

    private final AtividadeRepository atividadeRepository;

    private final AtividadeMapper atividadeMapper;

    private final DisciplinaRepository disciplinaRepository;

    public AtividadeServiceImpl(AtividadeRepository atividadeRepository, AtividadeMapper atividadeMapper, DisciplinaRepository disciplinaRepository) {
        this.atividadeRepository = atividadeRepository;
        this.atividadeMapper = atividadeMapper;
        this.disciplinaRepository = disciplinaRepository;
    }

    @Override
    public AtividadeResponseDTO criar(AtividadeCreateDTO dto) {
        if(atividadeRepository.findByDisciplinaIdAndTitulo(dto.disciplinaId(), dto.titulo()).isPresent()){
            throw new RecursoJaCadastradoException("Essa atividade já está cadastrada");
        }

        Disciplina disciplina = disciplinaRepository.findById(dto.disciplinaId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Disciplina não encontrada"));

        Atividade atividade = atividadeMapper.toEntity(dto,disciplina);

        Atividade salvo = atividadeRepository.save(atividade);

        return atividadeMapper.toResponseDTO(salvo);
    }

    @Override
    public AtividadeResponseDTO buscarPorId(Long id) {
        Atividade atividade = atividadeRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Atividade não encontrada com o id: " + id));


        return atividadeMapper.toResponseDTO(atividade);
    }

    @Override
    public Page<AtividadeResponseDTO> listar(Pageable pageable) {

        Page<Atividade> lista = atividadeRepository.findAll(pageable);
        return lista.map(atividade -> atividadeMapper.toResponseDTO(atividade));

    }

    @Override
    public Page<AtividadeResponseDTO> listarPorDisciplina(Long disciplinaId, Pageable pageable) {
        if(!disciplinaRepository.existsById(disciplinaId)){
            throw new RecursoNaoEncontradoException("Disciplina não encontrada com o id: " + disciplinaId);
        }
        Page<Atividade> lista = atividadeRepository.findByDisciplinaId(disciplinaId,pageable);
        return  lista.map(atividade -> atividadeMapper.toResponseDTO(atividade));
    }
}
