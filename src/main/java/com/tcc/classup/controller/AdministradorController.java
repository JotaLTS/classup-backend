package com.tcc.classup.controller;


import com.tcc.classup.dto.administrador.AdministradorCreateDTO;
import com.tcc.classup.dto.administrador.AdministradorResponseDTO;
import com.tcc.classup.service.administrador.AdministradorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/administradores")
public class AdministradorController {

    private final AdministradorService administradorService;

    public AdministradorController(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }

    @PostMapping
    public ResponseEntity<AdministradorResponseDTO> criar(@RequestBody AdministradorCreateDTO dto) {
        AdministradorResponseDTO criado = administradorService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }


    @GetMapping("/{id}")
    public ResponseEntity<AdministradorResponseDTO> buscarPorId(@PathVariable Long id) {

        return ResponseEntity.ok(administradorService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<Page<AdministradorResponseDTO>> listar(Pageable pageable) {

        return ResponseEntity.ok(administradorService.listar(pageable));


    }
}
