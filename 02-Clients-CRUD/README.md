# Introdução ao Spring Boot / Introduction to Spring Boot

[Português](#português) | [English](#english)

---

<a id="português"></a>
## Português

Este é um projeto simples que demonstra os conceitos básicos do Spring Boot. A aplicação implementa um endpoint REST que retorna uma mensagem "Hello World" junto com a data atual.

### Estrutura do Projeto

O projeto contém duas classes principais:

1. **IntroducaoApplication.java** - A classe principal com o método `main` que inicia a aplicação Spring Boot.
2. **HelloController.java** - Um controlador REST básico que define um endpoint `/hello`.

### Funcionalidades

- **Endpoint REST**: Acesse `/hello` para receber uma mensagem de saudação junto com a data atual.

### Tecnologias Utilizadas

- Spring Boot
- Spring Web
- Java

### Conceitos Demonstrados

- Configuração básica de uma aplicação Spring Boot
- Criação de endpoints REST com `@RestController`
- Mapeamento de URLs com `@GetMapping`
- Exibição de dados dinâmicos na resposta (data atual)

Este projeto serve como um ponto de partida para entender o funcionamento básico do Spring Boot antes de avançar para aplicações mais complexas.

---

<a id="english"></a>
## English

This is a simple project that demonstrates the basic concepts of Spring Boot. The application implements a REST endpoint that returns a "Hello World" message along with the current date.

### Project Structure

The project contains two main classes:

1. **IntroducaoApplication.java** - The main class with the `main` method that starts the Spring Boot application.
2. **HelloController.java** - A basic REST controller that defines a `/hello` endpoint.

### Features

- **REST Endpoint**: Access `/hello` to receive a greeting message along with the current date.

### Technologies Used

- Spring Boot
- Spring Web
- Java

### Demonstrated Concepts

- Basic configuration of a Spring Boot application
- Creation of REST endpoints with `@RestController`
- URL mapping with `@GetMapping`
- Display of dynamic data in the response (current date)

This project serves as a starting point for understanding the basic functionality of Spring Boot before moving on to more complex applications.
