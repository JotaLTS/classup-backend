package com.tcc.classup.controller;

import com.tcc.classup.dto.turma.TurmaCreateDTO;
import com.tcc.classup.dto.turma.TurmaResponseDTO;
import com.tcc.classup.service.turma.TurmaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    private final TurmaService turmaService;

    public TurmaController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    @PostMapping
    public ResponseEntity<TurmaResponseDTO> criar(@RequestBody TurmaCreateDTO dto) {
        TurmaResponseDTO criado = turmaService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TurmaResponseDTO> buscarPorId(@PathVariable Long id) {

        return ResponseEntity.ok(turmaService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<Page<TurmaResponseDTO>> listar(Pageable pageable) {

        return ResponseEntity.ok(turmaService.listar(pageable));

    }

}
