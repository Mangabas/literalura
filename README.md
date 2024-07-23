# Literalura

* [Sobre](#Sobre)
* [Gutendex](#Gutendex)
* [Funcionalidades](#Funcionalidades)
* [Pré-requisitos](#Pré-requisitos)
* [Tecnologias](#Tecnologias)
* [Badge](#Badge)
  
## Sobre
Literalura é um desafio da Alura juntamente da Oracle Next Education, seu objetivo é desenvolver uma aplicação Back-end para pesquisa de livros e autores por meio de uma API e guarda-los 
em um banco de dados.
## Gutendex
A Api utilizada é a da Gutendex, que facilita o acesso ao acervo do Projeto Gutenberg, uma coleção de livros de domínio público. Através da Gutendex, é possível buscar e filtrar livros por 
diversos critérios, como autor, título, idioma e assunto, tornando mais fácil encontrar e acessar milhares de obras literárias gratuitamente.  

É possível acessar a API por meio deste link:  
https://gutendex.com/

## Funcionalidades
- Buscar livro: Busca o livro baseado em seu nome.
- Listar livros: Lista todos os livros registrados no banco de dados.
- Listar autores: Lista todos os autores baseado nos livros registrados no banco de dados.
- Autores por ano: Lista todos os autores vivos em determinado ano.
- Livro por linguagem: Lista todos os livros disponíveis em uma de quatro linguagens: inglês, espanhol, francês e português.

## Pré-requisitos

- Java 17 ou superior instalado.
- Maven instalado para construção do projeto.
- Variáveis de ambiente `DB_HOST`, `DB_NAME`, `DB_USER`, `DB_PASSWORD` e `JWT_SECRET`.
- Configure um banco de dados `PostgreSQL` com o nome e credenciais especificadas em application.properties.

## Tecnologias
- **Spring Boot**
- **Spring Data JPA**
- **PostgreSQL**
- **Jackson**

## Badge
Este é um badge conquistado por ter desenvolvido este projeto com a Alura no programa ONE - "Oracle Next Education" em parceria com a Oracle:
![badge literalura](https://github.com/user-attachments/assets/e3974331-96d8-4482-9f45-8bfc40d431ee)

