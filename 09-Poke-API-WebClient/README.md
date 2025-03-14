# API de Consulta Pokémon / Pokémon Lookup API

[Português](#português) | [English](#english)

---

<a id="português"></a>
## Português

Esta API fornece um serviço para consulta de informações sobre Pokémon, utilizando a PokéAPI (pokeapi.co) como fonte de dados.

### Estrutura do Projeto

O projeto segue uma arquitetura em camadas:

1. **Controllers**: Gerenciam as requisições HTTP e respostas
   - `PokemonController.java`: Implementa endpoint REST para consulta de Pokémon

2. **Services**: Contém a lógica de negócio
   - `PokemonService.java`: Serviço responsável por fazer a chamada à API externa PokéAPI

3. **DTOs (Data Transfer Objects)**: Definem os dados de saída da API
   - `PokemonResponse.java`: Representa os dados retornados pela PokéAPI

4. **Configs**: Configurações do projeto
   - `WebClientConfig.java`: Configuração do WebClient para chamadas à PokéAPI

### Funcionalidades

A API oferece o seguinte endpoint:

- **GET /pokemon/{pokemonName}**: Consulta informações de um Pokémon a partir de seu ID na Pokédex

### Tecnologias Utilizadas

- Spring Boot
- Spring Webflux
- WebClient para requisições HTTP reativas
- Programação reativa com Reactor (Mono)
- Jackson para mapeamento JSON
- Lombok para redução de código boilerplate
- Tratamento de erros HTTP

### Como Usar

Para consultar informações de um Pokémon, faça uma requisição GET para:

```
GET /pokemon/25
```

Exemplo de resposta:

```json
{
  "pokedexNumber": 25,
  "pokemonName": "pikachu",
  "baseExperience": 112,
  "height": 4,
  "weight": 60
}
```

### Tratamento de Erros

A aplicação possui tratamento específico para diferentes tipos de erro:

- **Erro 4xx**: Quando o Pokémon não é encontrado, retorna uma mensagem indicando "Pokemon not found"
- **Erro 5xx**: Quando há um problema no servidor da PokéAPI, retorna uma mensagem indicando "Error in server"

---

<a id="english"></a>
## English

This API provides a service for looking up information about Pokémon, using the PokéAPI (pokeapi.co) as a data source.

### Project Structure

The project follows a layered architecture:

1. **Controllers**: Handle HTTP requests and responses
   - `PokemonController.java`: Implements REST endpoint for Pokémon lookup

2. **Services**: Contain business logic
   - `PokemonService.java`: Service responsible for making calls to the external PokéAPI

3. **DTOs (Data Transfer Objects)**: Define API output data
   - `PokemonResponse.java`: Represents data returned by the PokéAPI

4. **Configs**: Project configurations
   - `WebClientConfig.java`: WebClient configuration for PokéAPI calls

### Features

The API offers the following endpoint:

- **GET /pokemon/{pokemonName}**: Looks up information about a Pokémon based on its Pokédex ID

### Technologies Used

- Spring Boot
- Spring Webflux
- WebClient for reactive HTTP requests
- Reactive programming with Reactor (Mono)
- Jackson for JSON mapping
- Lombok for boilerplate code reduction
- HTTP error handling

### How to Use

To look up information about a Pokémon, make a GET request to:

```
GET /pokemon/25
```

Example response:

```json
{
  "pokedexNumber": 25,
  "pokemonName": "pikachu",
  "baseExperience": 112,
  "height": 4,
  "weight": 60
}
```

### Error Handling

The application has specific handling for different types of errors:

- **4xx Error**: When the Pokémon is not found, returns a message indicating "Pokemon not found"
- **5xx Error**: When there is a problem with the PokéAPI server, returns a message indicating "Error in server"