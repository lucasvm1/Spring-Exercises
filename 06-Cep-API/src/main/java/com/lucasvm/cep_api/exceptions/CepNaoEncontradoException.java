package com.lucasvm.cep_api.exceptions;

public class CepNaoEncontradoException extends RuntimeException {

    public CepNaoEncontradoException(String cep) {
        super("CEP not found: " + cep);
    }

}
