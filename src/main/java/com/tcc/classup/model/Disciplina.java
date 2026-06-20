package com.tcc.classup.model;



import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_disciplina")
@Getter
@NoArgsConstructor

public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @NotBlank
    @Column(nullable = false,length = 100)
    private String nome;

    @Setter
    @ManyToOne
    @JoinColumn(name = "turma_id",nullable = false)
    private Turma turma;

    @Setter
    @ManyToOne
    @JoinColumn(name = "professor_id",nullable = false)
    private Professor professor;
}
