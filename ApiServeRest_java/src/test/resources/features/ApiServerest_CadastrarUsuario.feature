#language:pt

Funcionalidade: Validar funcionalidades de Cadastro de usuário da Api Serverest

  Cenario: CT001 - Cadastrar usuário com sucesso
    Quando fizer uma requisição do tipo POST para cadastrar o usuário abaixo
      | nome          | "testeAutomacao"           |
      | email         | "testeAutomacao@email.com" |
      | password      | "teste123"                 |
      | administrador | "false"                    |
    Então a API retorna o status code 201
    E devo receber a mensagem "Cadastro realizado com sucesso"
    E o id do usuário cadastrado realizado com sucesso

  Cenario: CT002 - Tentativa de cadastro de usuário sem enviar os dados obrigatórios
    Quando fizer uma requisição do tipo POST para cadastrar o usuário abaixo
      | nome          | "" |
      | email         | "" |
      | password      | "" |
      | administrador | "" |
    Então a API retorna o status code 400
    E devo receber a mensagem de erro correspondente
      | nome          | nome não pode ficar em branco            |
      | email         | email não pode ficar em branco           |
      | password      | password não pode ficar em branco        |
      | administrador | administrador deve ser 'true' ou 'false' |

  Cenario: CT003 - Tentativa de cadastro de usuário com email inválido
    Quando fizer uma requisição do tipo POST para cadastrar o usuário abaixo
      | nome          | "testeAutomacao"          |
      | email         | "testeAutomacaoemail.com" |
      | password      | "teste123"                |
      | administrador | "false"                   |
    Então a API retorna o status code 400
    E devo receber a mensagem de erro correspondente
      | email | email deve ser um email válido |

  Cenario: CT004 - Tentativa de cadastro de usuário com email inválido
    Quando fizer uma requisição do tipo POST para cadastrar o usuário abaixo
      | nome          | "testeAutomacao"           |
      | email         | "testeAutomacao@email.com" |
      | password      | "teste123"                 |
      | administrador | "verdadeiro"               |
    Então a API retorna o status code 400
    E devo receber a mensagem de erro correspondente
      | administrador | administrador deve ser 'true' ou 'false' |
