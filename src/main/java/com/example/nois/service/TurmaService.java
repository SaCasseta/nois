package com.example.nois.service;

import com.example.nois.dto.TurmaDto;
import com.example.nois.entity.Turma;
import com.example.nois.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    public TurmaDto createTurma(TurmaDto turmaDto) {
        Turma turma = new Turma();
        turma.setNome(turmaDto.getNome());
        Turma savedTurma = turmaRepository.save(turma);
        return toDto(savedTurma);
    }

    public TurmaDto findById(Long id) {
        Turma turma = turmaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada com ID: " + id));
        return toDto(turma);
    }

    public List<TurmaDto> findAll() {
        return turmaRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public TurmaDto updateTurma(Long id, TurmaDto turmaDto) {
        Turma turma = turmaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada com ID: " + id));
        turma.setNome(turmaDto.getNome());
        Turma updatedTurma = turmaRepository.save(turma);
        return toDto(updatedTurma);
    }

    public void deleteTurma(Long id) {
        Turma turma = turmaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada com ID: " + id));
        turmaRepository.delete(turma);
    }

    private TurmaDto toDto(Turma turma) {
        TurmaDto dto = new TurmaDto();
        dto.setId(turma.getId());
        dto.setNome(turma.getNome());
        return dto;
    }
}