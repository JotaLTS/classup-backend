package com.tcc.classup.repository;

import com.tcc.classup.model.Atividade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Long> {

    Optional<Atividade> findByDisciplinaIdAndTitulo(Long disciplinaId, String titulo);

    Page<Atividade> findByDisciplinaId(Long disciplinaId, Pageable pageable);

}
