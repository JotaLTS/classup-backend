package com.tcc.classup.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_entrega_missao")
@Getter
@NoArgsConstructor
public class EntregaMissao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(length = 500)
    private String resposta;

    @Setter
    private String arquivoUrl;

    @Setter
    @DecimalMin("0.0")
    @DecimalMax("10.0")
    private Double nota;

    @Setter
    @Column(length = 500)
    private String feedback;

    @Setter
    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime dataEntrega;

    @Setter
    private LocalDateTime dataCorrecao;

    @Setter
    @ManyToOne
    @JoinColumn(name = "aluno_id",nullable = false)
    private Aluno aluno;

    @Setter
    @ManyToOne
    @JoinColumn(name = "missao_id",nullable = false)
    private Missao missao;

}
