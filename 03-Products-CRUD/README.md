# API de Gerenciamento de Produtos / Product Management API

[Português](#português) | [English](#english)

---

<a id="português"></a>
## Português

Este projeto implementa uma API REST para gerenciamento de produtos, demonstrando operações CRUD (Create, Read, Update, Delete) utilizando Spring Boot com foco em boas práticas de validação e tratamento de respostas.

### Estrutura do Projeto

O projeto segue uma arquitetura em camadas:

1. **Controllers**: Gerenciam as requisições HTTP e respostas
   - `ProductController.java`: Implementa endpoints REST para operações com produtos

2. **DTOs (Data Transfer Objects)**: Definem os dados de entrada e saída da API
   - `ProductDto.java`: Representa os dados para criação/atualização de produtos, com validações e mensagens de erro personalizadas

3. **Models**: Representam as entidades do domínio e mapeamento com o banco de dados
   - `ProductModel.java`: Entidade JPA para armazenamento dos dados de produtos

4. **Repositories**: Camada de acesso a dados
   - `ProductRepository.java`: Interface para operações de persistência

### Funcionalidades

A API oferece os seguintes endpoints:

- **POST /products**: Cria um novo produto
- **GET /products**: Lista todos os produtos cadastrados
- **GET /products/{id}**: Busca um produto específico por ID
- **PUT /products/{id}**: Atualiza os dados de um produto existente
- **DELETE /products/{id}**: Remove um produto do sistema

### Tecnologias Utilizadas

- Spring Boot
- Spring Data JPA
- Hibernate
- Validação com Jakarta Bean Validation
- BigDecimal para valores monetários
- UUID para identificadores únicos

### Conceitos Demonstrados

- Desenvolvimento de APIs RESTful
- Validação de dados de entrada com mensagens personalizadas
- Uso apropriado de BigDecimal para valores monetários
- Mapeamento objeto-relacional com JPA
- Operações CRUD completas
- Respostas HTTP adequadas (códigos de status)
- Conversão entre DTOs e entidades

---

<a id="english"></a>
## English

This project implements a REST API for product management, demonstrating CRUD operations (Create, Read, Update, Delete) using Spring Boot with a focus on validation best practices and response handling.

### Project Structure

The project follows a layered architecture:

1. **Controllers**: Handle HTTP requests and responses
   - `ProductController.java`: Implements REST endpoints for product operations

2. **DTOs (Data Transfer Objects)**: Define input and output data for the API
   - `ProductDto.java`: Represents data for product creation/update, with validations and custom error messages

3. **Models**: Represent domain entities and database mapping
   - `ProductModel.java`: JPA entity for storing product data

4. **Repositories**: Data access layer
   - `ProductRepository.java`: Interface for persistence operations

### Features

The API offers the following endpoints:

- **POST /products**: Creates a new product
- **GET /products**: Lists all registered products
- **GET /products/{id}**: Retrieves a specific product by ID
- **PUT /products/{id}**: Updates an existing product's data
- **DELETE /products/{id}**: Removes a product from the system

### Technologies Used

- Spring Boot
- Spring Data JPA
- Hibernate
- Jakarta Bean Validation
- BigDecimal for monetary values
- UUID for unique identifiers

### Demonstrated Concepts

- RESTful API development
- Input data validation with custom messages
- Proper use of BigDecimal for monetary values
- Object-relational mapping with JPA
- Complete CRUD operations
- Proper HTTP responses (status codes)
- Conversion between DTOs and entities
