package com.tcc.classup.controller;

import com.tcc.classup.dto.atividade.AtividadeCreateDTO;
import com.tcc.classup.dto.atividade.AtividadeResponseDTO;
import com.tcc.classup.service.atividade.AtividadeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/atividades")
public class AtividadeController {

    private final AtividadeService atividadeService;

    public AtividadeController(AtividadeService atividadeService) {
        this.atividadeService = atividadeService;
    }

    @PostMapping
    public ResponseEntity<AtividadeResponseDTO> criar(@RequestBody AtividadeCreateDTO dto){

        AtividadeResponseDTO criado = atividadeService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtividadeResponseDTO> buscarPorId(@PathVariable Long id){

        return ResponseEntity.ok(atividadeService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<Page<AtividadeResponseDTO>> listar(Pageable pageable){
        return ResponseEntity.ok(atividadeService.listar(pageable));
    }

    @GetMapping("/disciplina/{disciplinaId}")
    public ResponseEntity<Page<AtividadeResponseDTO>> listarPorDisciplina(@PathVariable Long disciplinaId, Pageable pageable){
        return ResponseEntity.ok(atividadeService.listarPorDisciplina(disciplinaId,pageable));
    }

}
