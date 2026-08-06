package com.tcc.classup.repository;

import com.tcc.classup.model.Aluno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno,Long> {

    Optional<Aluno> findByMatricula(String matricula);

    Page<Aluno> findByTurmaId(Long turmaId, Pageable pageable);

    Optional<Aluno> findByEmail(String email);

}
