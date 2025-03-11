# CEP API / Brazilian Postal Code API

[Português](#português) | [English](#english)

---

<a id="português"></a>
## Português

Esta API fornece um serviço para consulta de endereços através de CEP (Código de Endereçamento Postal), utilizando a API ViaCEP como fonte de dados.

### Estrutura do Projeto

O projeto segue uma arquitetura em camadas:

1. **Controllers**: Gerenciam as requisições HTTP e respostas
   - `CepController.java`: Implementa endpoint REST para consulta de CEP

2. **Services**: Contém a lógica de negócio
   - `CepService.java`: Serviço responsável por fazer a chamada à API externa ViaCEP

3. **DTOs (Data Transfer Objects)**: Definem os dados de resposta da API
   - `EnderecoResponseDto.java`: Representa os dados do endereço retornado

4. **Exceptions**: Classes de exceção personalizadas
   - `CepNaoEncontradoException.java`: Exceção lançada quando um CEP não é encontrado

### Funcionalidades

A API oferece o seguinte endpoint:

- **GET /cep/{cep}**: Consulta um endereço pelo CEP informado

### Tecnologias Utilizadas

- Spring Boot
- Spring Web
- RestTemplate para requisições HTTP
- Tratamento de exceções personalizado
- Logging com SLF4J

### Como Usar

Para consultar um endereço, faça uma requisição GET para:

```
GET /cep/01001000
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

Se o CEP não for encontrado ou for inválido, a API retornará um erro adequado.

---

<a id="english"></a>
## English

This API provides a service for querying addresses through Brazilian Postal Codes (CEP), using the ViaCEP API as the data source.

### Project Structure

The project follows a layered architecture:

1. **Controllers**: Handle HTTP requests and responses
   - `CepController.java`: Implements REST endpoint for CEP queries

2. **Services**: Contain business logic
   - `CepService.java`: Service responsible for making calls to the external ViaCEP API

3. **DTOs (Data Transfer Objects)**: Define API response data
   - `EnderecoResponseDto.java`: Represents the returned address data

4. **Exceptions**: Custom exception classes
   - `CepNaoEncontradoException.java`: Exception thrown when a CEP is not found

### Features

The API offers the following endpoint:

- **GET /cep/{cep}**: Queries an address by the provided postal code

### Technologies Used

- Spring Boot
- Spring Web
- RestTemplate for HTTP requests
- Custom exception handling
- Logging with SLF4J

### How to Use

To query an address, make a GET request to:

```
GET /cep/01001000
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

If the postal code is not found or is invalid, the API will return an appropriate error.
