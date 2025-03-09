# Introdução ao Spring Boot

Este é um projeto simples que demonstra os conceitos básicos do Spring Boot. A aplicação implementa um endpoint REST que retorna uma mensagem "Hello World" junto com a data atual.

## Estrutura do Projeto

O projeto contém duas classes principais:

1. **IntroducaoApplication.java** - A classe principal com o método `main` que inicia a aplicação Spring Boot.
2. **HelloController.java** - Um controlador REST básico que define um endpoint `/hello`.

## Funcionalidades

- **Endpoint REST**: Acesse `/hello` para receber uma mensagem de saudação junto com a data atual.

## Tecnologias Utilizadas

- Spring Boot
- Spring Web
- Java

## Conceitos Demonstrados

- Configuração básica de uma aplicação Spring Boot
- Criação de endpoints REST com `@RestController`
- Mapeamento de URLs com `@GetMapping`
- Exibição de dados dinâmicos na resposta (data atual)

Este projeto serve como um ponto de partida para entender o funcionamento básico do Spring Boot antes de avançar para aplicações mais complexas.
