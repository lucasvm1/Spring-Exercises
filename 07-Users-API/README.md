# User API / API de Usuários

[Português](#português) | [English](#english)

---

<a id="português"></a>
## Português

Esta API fornece um serviço para gerenciamento de usuários, utilizando a API ReqRes.in como backend para armazenamento de dados.

### Estrutura do Projeto

O projeto segue uma arquitetura em camadas:

1. **Controllers**: Gerenciam as requisições HTTP e respostas
   - `UsuarioController.java`: Implementa endpoint REST para criação de usuários

2. **Services**: Contém a lógica de negócio
   - `UsuarioService.java`: Serviço responsável por fazer a chamada à API externa ReqRes.in

3. **DTOs (Data Transfer Objects)**: Definem os dados de entrada e saída da API
   - `UsuarioRequestDto.java`: Representa os dados para criação de um usuário
   - `UsuarioResponseDto.java`: Representa os dados retornados após a criação do usuário

### Funcionalidades

A API oferece o seguinte endpoint:

- **POST /usuarios**: Cria um novo usuário com nome e cargo

### Tecnologias Utilizadas

- Spring Boot
- Spring Web
- RestTemplate para requisições HTTP
- Tratamento de exceções
- Logging com SLF4J

### Como Usar

Para criar um novo usuário, faça uma requisição POST para:

```
POST /usuarios
```

Exemplo de corpo da requisição:

```json
{
  "nome": "João Silva",
  "cargo": "Desenvolvedor"
}
```

Exemplo de resposta:

```json
{
  "nome": "João Silva",
  "cargo": "Desenvolvedor",
  "id": "123",
  "criadoEm": "2023-01-01T12:00:00Z"
}
```

### Tratamento de Erros

Se ocorrer algum erro na comunicação com a API externa, a aplicação registrará o erro e retornará um código de status apropriado ao cliente.

---

<a id="english"></a>
## English

This API provides a service for user management, using the ReqRes.in API as a backend for data storage.

### Project Structure

The project follows a layered architecture:

1. **Controllers**: Handle HTTP requests and responses
   - `UsuarioController.java`: Implements REST endpoint for creating users

2. **Services**: Contain business logic
   - `UsuarioService.java`: Service responsible for making calls to the external ReqRes.in API

3. **DTOs (Data Transfer Objects)**: Define API input and output data
   - `UsuarioRequestDto.java`: Represents data for user creation
   - `UsuarioResponseDto.java`: Represents data returned after user creation

### Features

The API offers the following endpoint:

- **POST /usuarios**: Creates a new user with name and role

### Technologies Used

- Spring Boot
- Spring Web
- RestTemplate for HTTP requests
- Exception handling
- Logging with SLF4J

### How to Use

To create a new user, make a POST request to:

```
POST /usuarios
```

Example request body:

```json
{
  "nome": "John Smith",
  "cargo": "Developer"
}
```

Example response:

```json
{
  "nome": "John Smith",
  "cargo": "Developer",
  "id": "123",
  "criadoEm": "2023-01-01T12:00:00Z"
}
```

### Error Handling

If an error occurs in communication with the external API, the application will log the error and return an appropriate status code to the client.
