package com.tcc.classup.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "tb_aluno_conquista",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"aluno_id", "conquista_id"}
                )
        }
)
@Getter
@NoArgsConstructor
public class AlunoConquista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "conquista_id", nullable = false)
    private Conquista conquista;

    @CreationTimestamp
    @Column(nullable = false,updatable = false)
    private LocalDateTime dataDesbloqueio;

}
