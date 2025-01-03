#language:pt

Funcionalidade: Validar funcionalidades de Edição de usuário da Api Serverest

  Cenario: CT001 - Editar um usuário com sucesso
    Dado que eu possua um usuário Cadastrado
    Quando fizer uma requisição do tipo PUT para editar o usuário com as informações abaixo
      | nome          | "testeAutomacao_editado"          |
      | email         | "testeAutomacao_editado@email.com" |
      | password      | "teste123_editado"                 |
      | administrador | "false"                            |
    Então devo receber a mensagem "Registro alterado com sucesso"
    E verifico que os dados do usuário foram atualizados na consulta

  Cenario: CT002 - Editar um usuário sem informar o id
    Dado que eu possua um usuário Cadastrado
    Quando fizer uma requisição do tipo PUT para editar o usuário com as informações abaixo sem informar o ID
      | nome          | "testeAutomacao_editado"          |
      | email         | "testeAutomacao_editado@email.com" |
      | password      | "teste123_editado"                 |
      | administrador | "false"                            |
    Então devo receber a mensagem "Não é possível realizar PUT em /usuarios/. Acesse https://serverest.dev para ver as rotas disponíveis e como utilizá-las."

  Cenario: CT003 - Editar um usuário sem informar nenhum dado
    Dado que eu possua um usuário Cadastrado
    Quando fizer uma requisição do tipo PUT para editar o usuário com as informações abaixo
      | nome          | "" |
      | email         | "" |
      | password      | "" |
      | administrador | "" |
    Então devo receber a mensagem de erro correspondente
      | nome          | nome não pode ficar em branco            |
      | email         | email não pode ficar em branco           |
      | password      | password não pode ficar em branco        |
      | administrador | administrador deve ser 'true' ou 'false' |

  Cenario: CT004 - Editar um usuário informando email que não seja válido
    Dado que eu possua um usuário Cadastrado
    Quando fizer uma requisição do tipo PUT para editar o usuário com as informações abaixo
      | nome          | "testeAutomacao_editado" |
      | email         | "email.com"               |
      | password      | "teste123_editado"        |
      | administrador | "false"                   |
    Então devo receber a mensagem de erro correspondente
      | email | email deve ser um email válido |

  Cenario: CT005 - Editar um usuário informando opção de administrator que não seja válida
    Dado que eu possua um usuário Cadastrado
    Quando fizer uma requisição do tipo PUT para editar o usuário com as informações abaixo
      | nome          | "testeAutomacao_editado" |
      | email         | "email.com"               |
      | password      | "teste123_editado"        |
      | administrador | "verdadeiro"              |
    Então devo receber a mensagem de erro correspondente
      | administrador | administrador deve ser 'true' ou 'false' |