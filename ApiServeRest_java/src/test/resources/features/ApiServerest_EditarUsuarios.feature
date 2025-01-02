#language:pt

Funcionalidade: Validar funcionalidades de Edição de usuário da Api Serverest

  Cenario: CT001 - Editar um usuário com sucesso
    Dado que eu possua um usuário Cadastrado
    Quando fizer uma requisição do tipo PUT para editar o usuário com as informações abaixo
      | nome          | "teste Automação editado"          |
      | email         | "testeautomacao_editado@email.com" |
      | password      | "teste123_editado"                 |
      | administrador | "false"                            |
    Então deve receber a mensagem "Registro alterado com sucesso"
    E verifico que os dados do usuário foram atualizados na consulta

  Cenario: CT002 - Editar um usuário sem informar o id
    Quando fizer uma requisição do tipo PUT para editar o usuário com as informações abaixo sem informar o ID
      | nome          | "teste Automação editado"          |
      | email         | "testeautomacao_editado@email.com" |
      | password      | "teste123_editado"                 |
      | administrador | "false"                            |
    Então deve receber a mensagem "Não é possível realizar PUT em /usuarios/. Acesse https://serverest.dev para ver as rotas disponíveis e como utilizá-las."