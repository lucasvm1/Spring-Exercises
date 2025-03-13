package com.lucasvm.Cep_API_WebClient.services;

import com.lucasvm.Cep_API_WebClient.dtos.CepResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class CepService {

    private final WebClient webClient;

    public CepService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<CepResponseDto> buscarEnderecoCep(String cep) {
        return webClient
                .get()
                .uri("/{cep}/json", cep)
                .retrieve()
                .bodyToMono(CepResponseDto.class);
    }


}
