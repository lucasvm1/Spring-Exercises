# API de Consulta de CEP / ZIP Code Lookup API

[Português](#português) | [English](#english)

---

<a id="português"></a>
## Português

Esta API fornece um serviço para consulta de endereços a partir de CEPs, utilizando a API ViaCEP como fonte de dados.

### Estrutura do Projeto

O projeto segue uma arquitetura em camadas:

1. **Controllers**: Gerenciam as requisições HTTP e respostas
   - `CepController.java`: Implementa endpoint REST para consulta de CEPs

2. **Services**: Contém a lógica de negócio
   - `CepService.java`: Serviço responsável por fazer a chamada à API externa ViaCEP

3. **DTOs (Data Transfer Objects)**: Definem os dados de saída da API
   - `CepResponseDto.java`: Representa os dados retornados pela API ViaCEP

4. **Configs**: Configurações do projeto
   - `WebClientConfig.java`: Configuração do WebClient para chamadas à API ViaCEP

### Funcionalidades

A API oferece o seguinte endpoint:

- **GET /api/{cep}**: Consulta informações de endereço a partir de um CEP

### Tecnologias Utilizadas

- Spring Boot
- Spring Webflux
- WebClient para requisições HTTP reativas
- Programação reativa com Reactor (Mono)
- Jackson para mapeamento JSON

### Como Usar

Para consultar informações de um CEP, faça uma requisição GET para:

```
GET /api/01001000
```

Exemplo de resposta:

```json
{
  "cep": "01001-000",
  "logradouro": "Praça da Sé",
  "complemento": "lado ímpar",
  "bairro": "Sé",
  "cidade": "São Paulo",
  "uf": "SP",
  "ibge": "3550308",
  "gia": "1004",
  "ddd": "11",
  "siafi": "7107"
}
```

### Tratamento de Erros

Se ocorrer algum erro na comunicação com a API externa ViaCEP, como CEP inválido ou serviço indisponível, a aplicação retornará um código de status apropriado ao cliente.

---

<a id="english"></a>
## English

This API provides a service for looking up addresses based on ZIP codes (CEP), using the ViaCEP API as a data source.

### Project Structure

The project follows a layered architecture:

1. **Controllers**: Handle HTTP requests and responses
   - `CepController.java`: Implements REST endpoint for ZIP code lookup

2. **Services**: Contain business logic
   - `CepService.java`: Service responsible for making calls to the external ViaCEP API

3. **DTOs (Data Transfer Objects)**: Define API output data
   - `CepResponseDto.java`: Represents data returned by the ViaCEP API

4. **Configs**: Project configurations
   - `WebClientConfig.java`: WebClient configuration for ViaCEP API calls

### Features

The API offers the following endpoint:

- **GET /api/{cep}**: Looks up address information from a ZIP code

### Technologies Used

- Spring Boot
- Spring Webflux
- WebClient for reactive HTTP requests
- Reactive programming with Reactor (Mono)
- Jackson for JSON mapping

### How to Use

To look up information for a ZIP code, make a GET request to:

```
GET /api/01001000
```

Example response:

```json
{
  "cep": "01001-000",
  "logradouro": "Praça da Sé",
  "complemento": "lado ímpar",
  "bairro": "Sé",
  "cidade": "São Paulo",
  "uf": "SP",
  "ibge": "3550308",
  "gia": "1004",
  "ddd": "11",
  "siafi": "7107"
}
```

### Error Handling

If an error occurs in communication with the external ViaCEP API, such as an invalid ZIP code or service unavailability, the application will return an appropriate status code to the client.