package com.tcc.classup.model;

import com.tcc.classup.enums.TipoAtividade;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_missao")
@Getter
@NoArgsConstructor
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @NotBlank
    @Column(nullable = false,length = 100)
    private String titulo;

    @Setter
    @NotBlank
    @Column(nullable = false,length = 500)
    private String descricao;

    @Setter
    @NotNull
    @Column(nullable = false)
    private TipoAtividade tipoAtividade;

    @Setter
    @NotNull
    @DecimalMin("0.0")
    @DecimalMax("10.0")
    @Column(nullable = false)
    private Double valor;

    @CreationTimestamp
    @Column(nullable = false,updatable = false)
    private LocalDateTime dataCriacao;

    @Setter
    @NotNull
    @Column(nullable = false)
    private LocalDateTime prazoEntrega;

    @Setter
    @ManyToOne
    @JoinColumn(name = "disciplina_id",nullable = false)
    private Disciplina disciplina;

}
