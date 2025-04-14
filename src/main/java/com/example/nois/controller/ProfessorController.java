package com.example.nois.controller;

import com.example.nois.dto.ProfessorDto;
import com.example.nois.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @PostMapping
    public ResponseEntity<ProfessorDto> createProfessor(@Valid @RequestBody ProfessorDto professorDto) {
        ProfessorDto createdProfessor = professorService.createProfessor(professorDto);
        return new ResponseEntity<>(createdProfessor, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorDto> getProfessorById(@PathVariable Long id) {
        ProfessorDto professor = professorService.findById(id);
        return new ResponseEntity<>(professor, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProfessorDto>> getAllProfessores() {
        List<ProfessorDto> professores = professorService.findAll();
        return new ResponseEntity<>(professores, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessorDto> updateProfessor(@PathVariable Long id, @Valid @RequestBody ProfessorDto professorDto) {
        ProfessorDto updatedProfessor = professorService.updateProfessor(id, professorDto);
        return new ResponseEntity<>(updatedProfessor, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfessor(@PathVariable Long id) {
        professorService.deleteProfessor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}