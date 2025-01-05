## Automação da Api SEVEREST 
Author: Edgar Silva

Data: Janeiro de 2025

## Descrição:

Esta automação foi criada do zero usando a linguagem JAVA para testar a Api https://serverest.dev/#/
Ela está rodando no github actions em cada pull request na branch main

## Requirements:
Java 17+
Maven

## O Escopo dessa automação é: 
Validar a Busca de usuários
Validar o Cadastro de usuários
Validar a Edição de usuários
Validar a Exclusão de usuários
Validar o Login de usuários

## Instalação:
Execute o comando abaixo para instalar todas as dependencias:
```mvn clean install```

## Execução:
Para rodar todos os testes, executar o comando abaixo no console:
```mvn clean test```

Para exe