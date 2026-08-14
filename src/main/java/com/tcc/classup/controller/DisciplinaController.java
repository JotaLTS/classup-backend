package com.tcc.classup.controller;

import com.tcc.classup.dto.disciplina.DisciplinaCreateDTO;
import com.tcc.classup.dto.disciplina.DisciplinaResponseDTO;
import com.tcc.classup.service.disciplina.DisciplinaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    private final DisciplinaService disciplinaService;

    public DisciplinaController(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    @PostMapping
    public ResponseEntity<DisciplinaResponseDTO> criar(@RequestBody DisciplinaCreateDTO dto){

        DisciplinaResponseDTO criado = disciplinaService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplinaResponseDTO> buscarPorId(@PathVariable Long id){

        return ResponseEntity.ok(disciplinaService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<Page<DisciplinaResponseDTO>> listar(Pageable pageable){

        return ResponseEntity.ok(disciplinaService.listar(pageable));
    }
}
