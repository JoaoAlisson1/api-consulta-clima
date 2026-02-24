package com.example.ClimaTracker.service;

import com.example.ClimaTracker.dto.ConsultaClimaRequestDTO;
import com.example.ClimaTracker.dto.ConsultaClimaResponseDTO;
import com.example.ClimaTracker.model.ConsultaClima;
import com.example.ClimaTracker.repository.ConsultaClimaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultaClimaService {

    private final ConsultaClimaRepository repository;
    private final OpenWeatherService openWeatherService;

    public ConsultaClimaResponseDTO salvar(ConsultaClimaRequestDTO request) {

        var response = openWeatherService.consultarClima(request.cidade());

        String descricao;

        if(response.weather() != null && response.weather().length > 0) {
            descricao = response.weather()[0].description();
        } else {
            descricao = "Sem descrição";
        }

        Double temperatura = null;

        if (response.main() != null) {
            temperatura = response.main().temp();
        }

        ConsultaClima clima = ConsultaClima.builder()
                .cidade(response.name())
                .temperatura(temperatura)
                .descricao(descricao)
                .data_consulta(LocalDateTime.now())
                .build();

        ConsultaClima salvo = repository.save(clima);

        return new ConsultaClimaResponseDTO(
                salvo.getId(),
                salvo.getCidade(),
                salvo.getTemperatura(),
                salvo.getDescricao(),
                salvo.getData_consulta()
        );
    }

    public List<ConsultaClimaResponseDTO> listar() {
        return repository.findAll()
                .stream()
                .map(clima -> new ConsultaClimaResponseDTO(
                        clima.getId(),
                        clima.getCidade(),
                        clima.getTemperatura(),
                        clima.getDescricao(),
                        clima.getData_consulta()
                ))
                .toList();
    }
}
