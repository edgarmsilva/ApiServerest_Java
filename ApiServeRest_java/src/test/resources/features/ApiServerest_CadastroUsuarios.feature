#language:pt

Funcionalidade: Validar funcionalidades de Cadastro de usuário da Api Serverest

  Cenario: CT001 - Cadastrar usuário com sucesso
    Quando fizer uma requisição do tipo POST para cadastrar o usuário abaixo
      | nome          | "automacao"                 |
      | email         | "automacao.teste@teste.com" |
      | password      | "teste123"                  |
      | administrador | "false"                     |
    Então deve receber a mensagem "Cadastro realizado com sucesso"
    E o id do usuário cadastrado realizado com sucesso

  Cenario: CT002 - Tentativa de cadastro de usuário sem enviar os dados obrigatórios
    Quando fizer uma requisição do tipo POST para cadastrar o usuário abaixo
      | nome          | "" |
      | email         | "" |
      | password      | "" |
      | administrador | "" |
    Então deve receber a mensagem de erro correspondente
      | nome          | nome não pode ficar em branco            |
      | email         | email não pode ficar em branco           |
      | password      | password não pode ficar em branco        |
      | administrador | administrador deve ser 'true' ou 'false' |

  Cenario: CT003 - Tentativa de cadastro de usuário com email inválido
    Quando fizer uma requisição do tipo POST para cadastrar o usuário abaixo
      | nome          | "teste"                 |
      | email         | "teste.teste@teste.com" |
      | password      | "teste123"              |
      | administrador | "true"                  |
    Então deve receber a mensagem de erro correspondente
      | email | email deve ser um email válido |

  Cenario: CT004 - Tentativa de cadastro de usuário com email inválido
    Quando fizer uma requisição do tipo POST para cadastrar o usuário abaixo
      | nome          | "teste"                 |
      | email         | "teste.teste@teste.com" |
      | password      | "teste123"              |
      | administrador | "verdadeiro"            |
    Então deve receber a mensagem de erro correspondente
      | administrador | administrador deve ser 'true' ou 'false' |
