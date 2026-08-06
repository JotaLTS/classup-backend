package com.tcc.classup.repository;


import com.tcc.classup.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository  extends JpaRepository<Turma,Long> {
}
