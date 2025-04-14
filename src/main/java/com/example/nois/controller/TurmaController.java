package com.example.nois.controller;

import com.example.nois.dto.TurmaDto;
import com.example.nois.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/turmas")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @PostMapping
    public ResponseEntity<TurmaDto> createTurma(@Valid @RequestBody TurmaDto turmaDto) {
        TurmaDto createdTurma = turmaService.createTurma(turmaDto);
        return new ResponseEntity<>(createdTurma, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurmaDto> getTurmaById(@PathVariable Long id) {
        TurmaDto turma = turmaService.findById(id);
        return new ResponseEntity<>(turma, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TurmaDto>> getAllTurmas() {
        List<TurmaDto> turmas = turmaService.findAll();
        return new ResponseEntity<>(turmas, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TurmaDto> updateTurma(@PathVariable Long id, @Valid @RequestBody TurmaDto turmaDto) {
        TurmaDto updatedTurma = turmaService.updateTurma(id, turmaDto);
        return new ResponseEntity<>(updatedTurma, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTurma(@PathVariable Long id) {
        turmaService.deleteTurma(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}