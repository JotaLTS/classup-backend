package com.tcc.classup.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<ErroResponseDTO> handleNaoEncontrado(RecursoNaoEncontradoException ex){
        ErroResponseDTO erro = new ErroResponseDTO(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }
    @ExceptionHandler(RecursoJaCadastradoException.class)
    public ResponseEntity<ErroResponseDTO> handleJaCadastrado(RecursoJaCadastradoException ex){
        ErroResponseDTO erro = new ErroResponseDTO(
                HttpStatus.CONFLICT.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErroResponseDTO> handleEmailOuSenhaInvalido(BadCredentialsException ex){
        ErroResponseDTO erro = new ErroResponseDTO(
                HttpStatus.UNAUTHORIZED.value(),
                "Email ou senha inválidos",
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(erro);
    }
}
