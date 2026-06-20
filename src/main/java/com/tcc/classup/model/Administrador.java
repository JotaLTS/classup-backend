package com.tcc.classup.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("ADMINISTRADOR")
@Getter
@Setter
@NoArgsConstructor

public class Administrador extends Usuario{

    @Setter
    @NotBlank
    @Column(nullable = false,unique = true)
    private String idFuncional;

}
