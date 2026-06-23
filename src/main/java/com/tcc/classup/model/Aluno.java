package com.tcc.classup.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("ALUNO")
@Getter
@NoArgsConstructor

public class Aluno extends Usuario{

    @NotBlank
    @Column(nullable = false,unique = true)
    private String matricula;

    @Setter
    @ManyToOne
    @JoinColumn(name = "turma_id",nullable = false)
    private Turma turma;

}
