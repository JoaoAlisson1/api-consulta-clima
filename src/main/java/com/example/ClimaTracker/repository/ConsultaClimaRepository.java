package com.example.ClimaTracker.repository;

import com.example.ClimaTracker.model.ConsultaClima;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaClimaRepository extends JpaRepository<ConsultaClima, Long> {
}
