package com.lucasvm.Poke_API_WebClient.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PokemonResponse {

    @JsonProperty("id")
    private int pokedexNumber;
    @JsonProperty("name")
    private String pokemonName;
    @JsonProperty("base_experience")
    private int baseExperience;
    private int height;
    private int weight;

}
