# Sistema de Gerenciamento de Pedidos / Order Management System

[Português](#português) | [English](#english)

---

<a id="português"></a>
## Português

Este projeto implementa uma API REST para um sistema de gerenciamento de pedidos completo, demonstrando a integração de múltiplas entidades relacionadas (Clientes, Produtos e Pedidos) utilizando Spring Boot.

### Estrutura do Projeto

O projeto segue uma arquitetura em camadas com relacionamentos complexos entre entidades:

1. **Controllers**: Gerenciam as requisições HTTP e respostas
   - `ClientController.java`: Endpoints para operações com clientes
   - `ProductController.java`: Endpoints para operações com produtos
   - `OrderController.java`: Endpoints para operações com pedidos

2. **DTOs (Data Transfer Objects)**: Definem os dados de entrada e saída da API
   - `ClientDto.java`: Dados e validações para clientes
   - `ProductDto.java`: Dados e validações para produtos
   - `OrderDto.java`: Estrutura para criação de pedidos
   - `OrderProductDto.java`: Estrutura para itens de pedido

3. **Models**: Representam as entidades do domínio com seus relacionamentos
   - `ClientModel.java`: Entidade Cliente com relacionamento OneToMany para Pedidos
   - `ProductModel.java`: Entidade Produto
   - `OrderModel.java`: Entidade Pedido com relacionamentos para Cliente e Itens
   - `OrderProductModel.java`: Tabela de junção entre Pedidos e Produtos

4. **Repositories**: Camada de acesso a dados
   - Repositórios JPA para cada entidade do sistema

### Funcionalidades

A API oferece funcionalidades completas para gerenciamento de um sistema de pedidos:

- **Clientes**: CRUD completo (cadastro, consulta, atualização e remoção)
- **Produtos**: CRUD completo para catálogo de produtos
- **Pedidos**: 
  - Criação de pedidos com múltiplos produtos
  - Cálculo automático do valor total
  - Validação de existência de clientes e produtos
  - Consulta de pedidos com seus itens

### Tecnologias Utilizadas

- Spring Boot
- Spring Data JPA
- Hibernate
- Validação com Jakarta Bean Validation
- UUID para identificadores únicos
- Relacionamentos JPA (OneToMany, ManyToOne)
- Cascade Operations

### Conceitos Demonstrados

- Modelagem de domínio com múltiplas entidades relacionadas
- Transações em operações complexas
- Validação de integridade referencial
- Mapeamento ORM de relacionamentos
- Criação e manipulação de estruturas de dados compostas
- Tratamento de erros e respostas HTTP apropriadas
- Uso de URIs semânticas

---

<a id="english"></a>
## English

This project implements a REST API for a complete order management system, demonstrating the integration of multiple related entities (Clients, Products, and Orders) using Spring Boot.

### Project Structure

The project follows a layered architecture with complex relationships between entities:

1. **Controllers**: Handle HTTP requests and responses
   - `ClientController.java`: Endpoints for client operations
   - `ProductController.java`: Endpoints for product operations
   - `OrderController.java`: Endpoints for order operations

2. **DTOs (Data Transfer Objects)**: Define input and output data for the API
   - `ClientDto.java`: Data and validations for clients
   - `ProductDto.java`: Data and validations for products
   - `OrderDto.java`: Structure for order creation
   - `OrderProductDto.java`: Structure for order items

3. **Models**: Represent domain entities with their relationships
   - `ClientModel.java`: Client entity with OneToMany relationship to Orders
   - `ProductModel.java`: Product entity
   - `OrderModel.java`: Order entity with relationships to Client and Items
   - `OrderProductModel.java`: Junction table between Orders and Products

4. **Repositories**: Data access layer
   - JPA repositories for each system entity

### Features

The API offers complete functionality for managing an order system:

- **Clients**: Complete CRUD (create, read, update, and delete)
- **Products**: Complete CRUD for product catalog
- **Orders**: 
  - Creation of orders with multiple products
  - Automatic calculation of total value
  - Validation of client and product existence
  - Querying orders with their items

### Technologies Used

- Spring Boot
- Spring Data JPA
- Hibernate
- Jakarta Bean Validation
- UUID for unique identifiers
- JPA Relationships (OneToMany, ManyToOne)
- Cascade Operations

### Demonstrated Concepts

- Domain modeling with multiple related entities
- Transactions in complex operations
- Referential integrity validation
- ORM mapping of relationships
- Creation and manipulation of composite data structures
- Error handling and appropriate HTTP responses
- Use of semantic URIs
