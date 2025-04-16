package com.example.nois.service;

import com.example.nois.dto.ProfessorDto;
import com.example.nois.entity.Professor;
import com.example.nois.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public ProfessorDto createProfessor(ProfessorDto professorDto) {
        Professor professor = new Professor();
        professor.setNome(professorDto.getNome());
        professor.setEmail(professorDto.getEmail());
        professor.setSenha(professorDto.getSenha());
        Professor savedProfessor = professorRepository.save(professor);
        return toDto(savedProfessor);
    }

    public ProfessorDto findById(Long id) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado com ID: " + id));
        return toDto(professor);
    }

    public List<ProfessorDto> findAll() {
        return professorRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public ProfessorDto updateProfessor(Long id, ProfessorDto professorDto) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado com ID: " + id));
        professor.setNome(professorDto.getNome());
        professor.setEmail(professorDto.getEmail());
        professor.setSenha(professorDto.getSenha());
        Professor updatedProfessor = professorRepository.save(professor);
        return toDto(updatedProfessor);
    }

    public void deleteProfessor(Long id) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado com ID: " + id));
        professorRepository.delete(professor);
    }

    private ProfessorDto toDto(Professor professor) {
        ProfessorDto dto = new ProfessorDto();
        dto.setId(professor.getId());
        dto.setNome(professor.getNome());
        dto.setEmail(professor.getEmail());
        dto.setSenha(professor.getSenha());
        return dto;
    }


    public boolean verifyCredentials(String email, String senha) {
        return professorRepository.findByEmailAndSenha(email, senha).isPresent();
    }
}