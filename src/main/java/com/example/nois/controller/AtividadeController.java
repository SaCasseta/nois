package com.example.nois.controller;

import com.example.nois.dto.AtividadeDto;
import com.example.nois.service.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/atividades")
public class AtividadeController {

    @Autowired
    private AtividadeService atividadeService;

    @PostMapping
    public ResponseEntity<AtividadeDto> createAtividade(@Valid @RequestBody AtividadeDto atividadeDto) {
        AtividadeDto createdAtividade = atividadeService.createAtividade(atividadeDto);
        return new ResponseEntity<>(createdAtividade, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtividadeDto> getAtividadeById(@PathVariable Long id) {
        AtividadeDto atividade = atividadeService.findById(id);
        return new ResponseEntity<>(atividade, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AtividadeDto>> getAllAtividades() {
        List<AtividadeDto> atividades = atividadeService.findAll();
        return new ResponseEntity<>(atividades, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AtividadeDto> updateAtividade(@PathVariable Long id, @Valid @RequestBody AtividadeDto atividadeDto) {
        AtividadeDto updatedAtividade = atividadeService.updateAtividade(id, atividadeDto);
        return new ResponseEntity<>(updatedAtividade, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAtividade(@PathVariable Long id) {
        atividadeService.deleteAtividade(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}