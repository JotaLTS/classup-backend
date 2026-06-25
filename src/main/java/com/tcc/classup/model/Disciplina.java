package com.tcc.classup.model;



import com.tcc.classup.enums.TipoTurma;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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
    @Column(nullable = false,length = 100,unique = true)
    private String nome;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoTurma tipoTurma;

    @Setter
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @OneToMany(mappedBy = "disciplina")
    private List<Conquista> conquistas = new ArrayList<>();

    @OneToMany(mappedBy = "disciplina")
    private List<MaterialApoio> materiaisApoio = new ArrayList<>();

    @OneToMany(mappedBy = "disciplina")
    private List<Atividade> atividades = new ArrayList<>();
}
