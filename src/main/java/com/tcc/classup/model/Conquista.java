package com.tcc.classup.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
        name = "tb_conquista",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"disciplina_id","pontuacao_minima"}
                )
        }
)
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
    @Min(0)
    @Max(20)
    @Column(nullable = false)
    private Integer pontuacaoMinima;

    @ManyToOne
    @JoinColumn(name = "disciplina_id", nullable = false)
    private Disciplina disciplina;

}
