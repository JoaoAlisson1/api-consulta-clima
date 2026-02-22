package com.example.ClimaTracker.dto;

public record OpenWeatherResponseDTO(
        DadosPrincipais main,
        CondicaoClima[] weather,
        String name
) {
    public record DadosPrincipais(Double temp) {}
    public record CondicaoClima(String description) {}
}
