package com.tcc.classup.repository;

import com.tcc.classup.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina,Long> {

    Optional<Disciplina> findByNome (String nome);

}
