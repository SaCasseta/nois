package com.example.nois.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtividadeDto {
    private Long id;

    @NotBlank(message = "A matéria é obrigatória")
    private String materia;
}