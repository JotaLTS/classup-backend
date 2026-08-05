package com.tcc.classup.repository.administrador;

import com.tcc.classup.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador,Long> {

    Optional<Administrador> findByIdFuncional(String idFuncional);
    
}
