package com.lucasvm.Poke_API_WebClient.services;

import com.lucasvm.Poke_API_WebClient.dtos.PokemonResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class PokemonService {

    private final WebClient webClient;

    public PokemonService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<PokemonResponse> getPokemonInfo(int pokemonName){
        return webClient
                .get()
                .uri("/{pokemonName}", pokemonName)
                .retrieve()
                .onStatus(
                        status -> status.is4xxClientError(),
                        response -> response.bodyToMono(String.class)
                        .flatMap(body -> Mono.error(new RuntimeException("Error: Pokemon not found")))
                )
                .onStatus(
                        status -> status.is5xxServerError(),
                        response -> response.bodyToMono(String.class)
                                .flatMap(body -> Mono.error(new RuntimeException("Error: Error in server")))
                )
                .bodyToMono(PokemonResponse.class);
    }


}
