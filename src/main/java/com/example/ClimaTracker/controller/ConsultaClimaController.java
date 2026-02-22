package com.example.ClimaTracker.controller;

import com.example.ClimaTracker.dto.ConsultaClimaRequestDTO;
import com.example.ClimaTracker.dto.ConsultaClimaResponseDTO;
import com.example.ClimaTracker.service.ConsultaClimaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clima")

public class ConsultaClimaController {

    private final ConsultaClimaService service;

    @PostMapping
    public ConsultaClimaResponseDTO salvar(@RequestBody @Valid ConsultaClimaRequestDTO request) {
        return service.salvar(request);
    }

    @GetMapping
    public List<ConsultaClimaResponseDTO> listar() {
        return service.listar();
    }

}
