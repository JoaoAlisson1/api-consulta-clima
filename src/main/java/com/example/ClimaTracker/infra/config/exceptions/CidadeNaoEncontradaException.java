package com.example.ClimaTracker.infra.config.exceptions;

public class CidadeNaoEncontradaException extends RuntimeException {

  public CidadeNaoEncontradaException(String message) {
        super(message);
    }
}
