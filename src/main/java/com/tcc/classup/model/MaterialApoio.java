package com.tcc.classup.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_material_apoio")
@Getter
@NoArgsConstructor
public class MaterialApoio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @NotBlank
    @Column(nullable = false, length = 100)
    private String titulo;

    @Setter
    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Setter
    @NotBlank
    @Column(nullable = false)
    private String nomeArquivo;

    @Setter
    @NotBlank
    @Column(nullable = false)
    private String arquivoUrl;

    @Setter
    @ManyToOne
    @JoinColumn(name = "disciplina_id", nullable = false)
    private Disciplina disciplina;

}