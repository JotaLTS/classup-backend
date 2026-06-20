package com.tcc.classup.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("PROFESSOR")
@Getter
@NoArgsConstructor

public class Professor extends Usuario{

    @Setter
    @NotBlank
    @Column(nullable = false,unique = true)
    private String idFuncional;

    @OneToMany(mappedBy = "professor")
    private List<Disciplina> disciplinas = new ArrayList<>();
}
