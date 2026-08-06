package com.tcc.classup.controller;

import com.tcc.classup.dto.professor.ProfessorCreateDTO;
import com.tcc.classup.dto.professor.ProfessorResponseDTO;
import com.tcc.classup.service.professor.ProfessorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping
    public ResponseEntity<ProfessorResponseDTO> criar(@RequestBody ProfessorCreateDTO dto) {
        ProfessorResponseDTO criado = professorService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProfessorResponseDTO> buscarPorId(@PathVariable Long id) {

        return ResponseEntity.ok(professorService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<Page<ProfessorResponseDTO>> listar(Pageable pageable) {

        return ResponseEntity.ok(professorService.listar(pageable));

    }
}
