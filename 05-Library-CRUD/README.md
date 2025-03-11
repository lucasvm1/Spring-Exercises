# Sistema de Gerenciamento de Biblioteca / Library Management System

[Português](#português) | [English](#english)

---

## For API Documentation
<a target="https://github.com/lucasvm1/Spring-Exercises/blob/main/05-Library-CRUD/API-DOCUMENTATION.md">API Documentation<a>

---

<a id="português"></a>
## Português

Este projeto implementa uma API REST para um sistema de gerenciamento de biblioteca completo, demonstrando a integração de múltiplas entidades relacionadas (Autores, Livros, Usuários e Empréstimos) utilizando Spring Boot.

### Estrutura do Projeto

O projeto segue uma arquitetura em camadas com relacionamentos complexos entre entidades:

1. **Controllers**: Gerenciam as requisições HTTP e respostas
   - `AuthorController.java`: Endpoints para operações com autores
   - `BookController.java`: Endpoints para operações com livros
   - `UserController.java`: Endpoints para operações com usuários
   - `LoanController.java`: Endpoints para operações com empréstimos

2. **DTOs (Data Transfer Objects)**: Definem os dados de entrada e saída da API
   - `AuthorDto.java`: Dados e validações para autores
   - `BookDto.java`: Dados e validações para livros
   - `UserDto.java`: Dados e validações para usuários
   - `LoanDto.java`: Estrutura para criação de empréstimos

3. **Models**: Representam as entidades do domínio com seus relacionamentos
   - `AuthorModel.java`: Entidade Autor com relacionamento OneToMany para Livros
   - `BookModel.java`: Entidade Livro com relacionamento ManyToOne para Autor
   - `UserModel.java`: Entidade Usuário
   - `LoanModel.java`: Entidade Empréstimo com relacionamentos para Livro e Usuário

4. **Repositories**: Camada de acesso a dados
   - Repositórios JPA para cada entidade do sistema

5. **Enums**: Tipos enumerados para o sistema
   - `LoanStatus.java`: Estados possíveis de um empréstimo (ACTIVE, RETURNED, OVERDUE)

### Funcionalidades

A API oferece funcionalidades completas para gerenciamento de um sistema de biblioteca:

- **Autores**: CRUD completo (cadastro, consulta, atualização e remoção)
- **Livros**: CRUD completo para catálogo de livros, associados a autores
- **Usuários**: CRUD completo para gerenciamento de membros da biblioteca
- **Empréstimos**: 
  - Criação de empréstimos de livros para usuários
  - Verificação de disponibilidade de livros
  - Controle de datas de empréstimo e devolução
  - Atualização de status (ativo, devolvido)
  - Processo de devolução de livros

### Tecnologias Utilizadas

- Spring Boot
- Spring Data JPA
- Hibernate
- Validação com Jakarta Bean Validation
- UUID para identificadores únicos
- Relacionamentos JPA (OneToMany, ManyToOne)
- Mapeamento de Enums

### Conceitos Demonstrados

- Modelagem de domínio com múltiplas entidades relacionadas
- Transações em operações complexas
- Validação de integridade referencial
- Mapeamento ORM de relacionamentos
- Controle de status e estados de entidades
- Verificações de regras de negócio (disponibilidade de livros)
- Tratamento de erros e respostas HTTP apropriadas
- Uso de URIs semânticas

---

<a id="english"></a>
## English

This project implements a REST API for a complete library management system, demonstrating the integration of multiple related entities (Authors, Books, Users, and Loans) using Spring Boot.

### Project Structure

The project follows a layered architecture with complex relationships between entities:

1. **Controllers**: Handle HTTP requests and responses
   - `AuthorController.java`: Endpoints for author operations
   - `BookController.java`: Endpoints for book operations
   - `UserController.java`: Endpoints for user operations
   - `LoanController.java`: Endpoints for loan operations

2. **DTOs (Data Transfer Objects)**: Define input and output data for the API
   - `AuthorDto.java`: Data and validations for authors
   - `BookDto.java`: Data and validations for books
   - `UserDto.java`: Data and validations for users
   - `LoanDto.java`: Structure for loan creation

3. **Models**: Represent domain entities with their relationships
   - `AuthorModel.java`: Author entity with OneToMany relationship to Books
   - `BookModel.java`: Book entity with ManyToOne relationship to Author
   - `UserModel.java`: User entity
   - `LoanModel.java`: Loan entity with relationships to Book and User

4. **Repositories**: Data access layer
   - JPA repositories for each system entity

5. **Enums**: Enumerated types for the system
   - `LoanStatus.java`: Possible states of a loan (ACTIVE, RETURNED, OVERDUE)

### Features

The API offers complete functionality for managing a library system:

- **Authors**: Complete CRUD (create, read, update, and delete)
- **Books**: Complete CRUD for book catalog, associated with authors
- **Users**: Complete CRUD for library member management
- **Loans**: 
  - Creation of book loans for users
  - Verification of book availability
  - Control of loan and return dates
  - Status updates (active, returned)
  - Book return process

### Technologies Used

- Spring Boot
- Spring Data JPA
- Hibernate
- Jakarta Bean Validation
- UUID for unique identifiers
- JPA Relationships (OneToMany, ManyToOne)
- Enum Mapping

### Demonstrated Concepts

- Domain modeling with multiple related entities
- Transactions in complex operations
- Referential integrity validation
- ORM mapping of relationships
- Entity status and state control
- Business rule verifications (book availability)
- Error handling and appropriate HTTP responses
- Use of semantic URIs