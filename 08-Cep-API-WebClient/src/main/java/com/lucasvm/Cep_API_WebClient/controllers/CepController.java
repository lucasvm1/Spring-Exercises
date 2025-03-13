package com.lucasvm.Cep_API_WebClient.controllers;

import com.lucasvm.Cep_API_WebClient.dtos.CepResponseDto;
import com.lucasvm.Cep_API_WebClient.services.CepService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class CepController {

    private final CepService cepService;

    public CepController(CepService cepService) {
        this.cepService = cepService;
    }

    @GetMapping("/{cep}")
    public Mono<CepResponseDto> getEndereco(@PathVariable String cep) {
        return cepService.buscarEnderecoCep(cep);
    }

}
