package com.tcc.classup.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_turma")
@Getter
@NoArgsConstructor
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @NotBlank
    @Column(nullable = false,length = 100)
    private String nome;

    @Setter
    @NotNull
    @Min(2000)
    @Column(nullable = false)
    private Integer ano;

    @Setter
    @NotNull
    @Min(1)
    @Max(2)
    @Column(nullable = false)
    private Integer semestre;

    @Setter
    @NotNull
    @Column(nullable = false)
    private LocalDate dataInicio;

    @Setter
    @NotNull
    @Column(nullable = false)
    private LocalDate dataFim;

    @OneToMany(mappedBy = "turma")
    private List<Aluno> alunos = new ArrayList<>();

    @OneToMany(mappedBy = "turma")
    private List<Disciplina> disciplinas = new ArrayList<>();
}
