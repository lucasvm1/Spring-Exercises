package com.lucasvm.Poke_API_WebClient.controllers;


import com.lucasvm.Poke_API_WebClient.dtos.PokemonResponse;
import com.lucasvm.Poke_API_WebClient.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/{pokemonName}")
    public Mono<PokemonResponse> getPokemon(@PathVariable String pokemonName) {

        return pokemonService.getPokemonInfo(pokemonName);

    }

}
