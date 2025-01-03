#language:pt

Funcionalidade: Validar funcionalidades de Cadastro de usuário da Api Serverest

  Cenario: CT001 - busca usuário por ID com sucesso
    Dado que eu possua um usuário Cadastrado
    Quando fizer uma requisição do tipo GET para buscar o usuário utilizando seu ID
    Então a API retorna o status code 200
    E devo receber os dados do usuário
      | nome          | testeAutomacao           |
      | email         | testeAutomacao@email.com |
      | password      | teste123                 |
      | administrador | false                    |
      | _id           | <id>                     |

  Cenario: CT002 - busca usuário por ID sem informar o ID
    Dado que eu possua um usuário Cadastrado
    Quando fizer uma requisição do tipo GET para buscar o usuário sem informar um ID
    Então a API retorna o status code 400
    E devo receber a mensagem "Usuário não encontrado"