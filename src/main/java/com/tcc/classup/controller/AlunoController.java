package com.tcc.classup.controller;

import com.tcc.classup.dto.aluno.AlunoCreateDTO;
import com.tcc.classup.dto.aluno.AlunoResponseDTO;
import com.tcc.classup.service.aluno.AlunoService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public ResponseEntity<AlunoResponseDTO> criar(@RequestBody AlunoCreateDTO dto){

        AlunoResponseDTO criado = alunoService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponseDTO> buscarPorId(@PathVariable Long id){

        return ResponseEntity.ok(alunoService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<Page<AlunoResponseDTO>> listar(Pageable pageable){

        return ResponseEntity.ok(alunoService.listar(pageable));
    }
    @GetMapping("/turma/{turmaId}")
    public ResponseEntity<Page<AlunoResponseDTO>> listarPorTurma(@PathVariable Long turmaId, Pageable pageable){

        return ResponseEntity.ok(alunoService.listarPorTurma(turmaId, pageable));
    }
}
