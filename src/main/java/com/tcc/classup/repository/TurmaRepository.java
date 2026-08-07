package com.tcc.classup.repository;


import com.tcc.classup.enums.TipoTurma;
import com.tcc.classup.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TurmaRepository  extends JpaRepository<Turma,Long> {

    Optional<Turma> findByTipoTurmaAndAnoAndSemestre(TipoTurma tipoTurma, Integer ano, Integer semestre);


}
