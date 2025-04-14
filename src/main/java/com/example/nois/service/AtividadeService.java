package com.example.nois.service;

import com.example.nois.dto.AtividadeDto;
import com.example.nois.entity.Atividade;
import com.example.nois.repository.AtividadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AtividadeService {

    @Autowired
    private AtividadeRepository atividadeRepository;

    public AtividadeDto createAtividade(AtividadeDto atividadeDto) {
        Atividade atividade = new Atividade();
        atividade.setMateria(atividadeDto.getMateria());
        Atividade savedAtividade = atividadeRepository.save(atividade);
        return toDto(savedAtividade);
    }

    public AtividadeDto findById(Long id) {
        Atividade atividade = atividadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Atividade não encontrada com ID: " + id));
        return toDto(atividade);
    }

    public List<AtividadeDto> findAll() {
        return atividadeRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public AtividadeDto updateAtividade(Long id, AtividadeDto atividadeDto) {
        Atividade atividade = atividadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Atividade não encontrada com ID: " + id));
        atividade.setMateria(atividadeDto.getMateria());
        Atividade updatedAtividade = atividadeRepository.save(atividade);
        return toDto(updatedAtividade);
    }

    public void deleteAtividade(Long id) {
        Atividade atividade = atividadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Atividade não encontrada com ID: " + id));
        atividadeRepository.delete(atividade);
    }

    private AtividadeDto toDto(Atividade atividade) {
        AtividadeDto dto = new AtividadeDto();
        dto.setId(atividade.getId());
        dto.setMateria(atividade.getMateria());
        return dto;
    }
}