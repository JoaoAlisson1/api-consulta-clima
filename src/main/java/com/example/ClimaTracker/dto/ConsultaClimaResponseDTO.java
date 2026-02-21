package com.example.ClimaTracker.dto;

import java.time.LocalDateTime;

public record ConsultaClimaResponseDTO(
        Long id,
        String cidade,
        Double temperatura,
        String descricao,
        LocalDateTime data_consulta
) {}
