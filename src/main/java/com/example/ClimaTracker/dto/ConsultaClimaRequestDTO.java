package com.example.ClimaTracker.dto;

import jakarta.validation.constraints.NotBlank;

public record ConsultaClimaRequestDTO(
        @NotBlank(message = "Cidade é obrigatória")
        String cidade
) {}
