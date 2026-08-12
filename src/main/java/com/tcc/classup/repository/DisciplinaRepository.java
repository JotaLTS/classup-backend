package com.tcc.classup.repository;

import com.tcc.classup.enums.TipoTurma;
import com.tcc.classup.model.Disciplina;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface DisciplinaRepository {

    Optional<Disciplina> findByNome (String nome);

}
