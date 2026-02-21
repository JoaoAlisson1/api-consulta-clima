package com.example.ClimaTracker.dto;

public record ConsultaClimaRequestDTO(
        String cidade,
        Double temperatura,
        String descricao
) {}
