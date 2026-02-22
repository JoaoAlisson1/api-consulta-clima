package com.example.ClimaTracker.service;

import com.example.ClimaTracker.dto.OpenWeatherResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class OpenWeatherService {
    private final RestTemplate restTemplate;

    @Value("${openweather.api.key}")
    private String apiKey;

    public OpenWeatherResponseDTO consultarClima(String cidade) {

        String url = "https://api.openweathermap.org/data/2.5/weather?q=" +
                cidade + "&appid=" + apiKey +  "&units=metric&lang=pt_br";

                return restTemplate.getForObject(url, OpenWeatherResponseDTO.class);
    }
}
