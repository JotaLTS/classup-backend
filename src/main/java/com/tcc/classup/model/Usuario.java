package com.tcc.classup.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_usuario")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_usuario")
@Getter
@NoArgsConstructor

public abstract class  Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @NotBlank
    @Column(nullable = false,length = 100)
    private String nome;

    @Setter
    @Email
    @NotBlank
    @Column(unique = true,nullable = false)
    private String email;

    @Setter
    @NotBlank
    @Size(min = 8,max = 100)
    @Column(nullable = false)
    private String senha;

    @CreationTimestamp
    @Column(nullable = false,updatable = false)
    private LocalDateTime dataCriacao;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime dataAtualizacao;

    @Setter
    @Column(nullable = false)
    private boolean estaAtivo = true;

}
