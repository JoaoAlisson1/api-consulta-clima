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

    public ConsultaClimaResponseDTO salvar(ConsultaClimaRequestDTO request) {
        ConsultaClima clima = ConsultaClima.builder()
                .cidade(request.cidade())
                .temperatura(request.temperatura())
                .descricao(request.descricao())
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
