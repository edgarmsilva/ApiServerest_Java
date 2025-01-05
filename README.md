## Automação da Api SEVEREST 
Author: Edgar Silva

Data: Janeiro de 2025

### Descrição:

Esta automação foi criada do zero usando a linguagem JAVA e o Rest Assured para testar a Api https://serverest.dev/#/
Ela está rodando no github actions em cada pull request na branch main e está estruturada da seguinte forma:

 - resources/features: os cenários estão escritos na linguagem Gherkin
 - java/api: métodos de chamada da api (GET, POST, DELETE, PUT)
 - java/runner: configurações do cucumber para execução do projeto
 - java/stepDefinitions: implementação dos steps das features e o arquivo de suporte

### Requirements:
- Java 17
- Maven

### O Escopo dessa automação é: 
Validar a Busca de usuários 
Validar o Cadastro de usuários
Validar a Edição de usuários
Validar a Exclusão de usuários
Validar o Login de usuários

### Instalação:
Execute o comando abaixo para instalar todas as dependencias:
```mvn clean install```

### Execução local:
Para rodar todos os testes, executar o comando abaixo no console:

```mvn clean test```

Para gerar o report com o Allure executar os comandos:

```irm get.scoop.sh | iex```

```scoop install allure```

Após a Execução dos testes, rodar o comando abaixo para visualizar o report:

```mvn allure:serve```

### Execução através do github Actions manualmente:
Acessar o actions do projeto:
https://github.com/edgarmsilva/ApiServerest_Java/actions

clicar em "Executar testes Manuais"
 - depois no dropdown "Run Workflow" 
 - Selecionar a branch main
 - Clicar no botão "Run Workflow"



