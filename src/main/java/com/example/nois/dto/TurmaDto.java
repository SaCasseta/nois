package com.example.nois.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TurmaDto {


    @NotBlank(message = "O nome é obrigatório")
    private String nome;
}