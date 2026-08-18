package com.tcc.classup.security;

import com.tcc.classup.model.Administrador;
import com.tcc.classup.model.Aluno;
import com.tcc.classup.model.Professor;
import com.tcc.classup.model.Usuario;
import com.tcc.classup.repository.UsuarioRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioUserDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado"));
        String role;
        switch (usuario) {
            case Aluno aluno -> role = "ROLE_ALUNO";
            case Professor professor -> role = "ROLE_PROFESSOR";
            case Administrador administrador -> role = "ROLE_ADMINISTRADOR";
            default -> throw new IllegalStateException("Tipo de usuário desconhecido");
        }
        return User.builder()
                .username(usuario.getEmail())
                .password(usuario.getSenha())
                .authorities(List.of(new SimpleGrantedAuthority(role)))
                .build();
    }
}
