package com.tcc.classup.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_conquista")
@Getter
@NoArgsConstructor
public class Conquista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @NotBlank
    @Column(nullable = false,length = 100)
    private String titulo;

    @Setter
    @NotBlank
    @Column(nullable = false,columnDefinition = "TEXT")
    private String descricao;

    @Setter
    @NotNull
    @DecimalMin("0.0")
    @DecimalMax("20.0")
    @Column(nullable = false)
    private Double pontuacaoMinima;

    @ManyToOne
    @JoinColumn(name = "disciplina_id", nullable = false)
    private Disciplina disciplina;

}
