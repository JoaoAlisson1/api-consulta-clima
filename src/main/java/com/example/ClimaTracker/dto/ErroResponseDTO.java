package com.example.ClimaTracker.dto;

import java.time.LocalDateTime;

public record ErroResponseDTO(
        int status,
        String erro,
        String mensagem,
        LocalDateTime timestamp
) {
}
