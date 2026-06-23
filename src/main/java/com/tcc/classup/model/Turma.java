package com.tcc.classup.model;

import com.tcc.classup.enums.TipoTurma;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name = "tb_turma",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"tipo_turma", "ano","semestre"}
                )
        }
)
@Getter
@NoArgsConstructor
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoTurma tipoTurma;

    @NotNull
    @Min(2000)
    @Max(2100)
    @Column(nullable = false)
    private Integer ano;

    @NotNull
    @Min(1)
    @Max(2)
    @Column(nullable = false)
    private Integer semestre;

    @OneToMany(mappedBy = "turma")
    private List<Aluno> alunos = new ArrayList<>();
}
