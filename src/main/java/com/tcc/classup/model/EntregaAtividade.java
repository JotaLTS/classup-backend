package com.tcc.classup.model;

import com.tcc.classup.enums.StatusEntrega;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "tb_entrega_atividade",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"aluno_id", "atividade_id"}
                )
        }
)
@Getter
@NoArgsConstructor
public class EntregaAtividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(columnDefinition = "TEXT")
    private String resposta;

    @Setter
    @Column(length = 1000)
    private String arquivoUrl;

    @Setter
    @DecimalMin("0.0")
    @DecimalMax("10.0")
    private Double nota;

    @Setter
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusEntrega status;

    @Setter
    @Column(length = 500)
    private String feedback;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime dataEntrega;

    @Setter
    private LocalDateTime dataCorrecao;

    @ManyToOne
    @JoinColumn(name = "aluno_id",nullable = false)
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "atividade_id",nullable = false)
    private Atividade atividade;

}
