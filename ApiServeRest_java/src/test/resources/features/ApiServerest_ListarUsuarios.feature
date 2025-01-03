#language:pt

Funcionalidade: Validar funcionalidade de Listar usuários da Api Serverest

  Cenario: CT001 - Buscar um usuário com sucesso através do id
    Dado que eu possua um usuário Cadastrado
    Quando fizer uma requisição do tipo GET para listar o usuário com as informações abaixo
      | _id | "" |
    Então devo receber a lista com o retorno dos usuários correspondentes

  Cenario: CT002 - Buscar um usuário com sucesso através do nome
    Dado que eu possua um usuário Cadastrado
    Quando fizer uma requisição do tipo GET para listar o usuário com as informações abaixo
      | nome | testeAutomacao |
    Então devo receber a lista com o retorno dos usuários correspondentes

  Cenario: CT003 - Buscar um usuário com sucesso através do email
    Dado que eu possua um usuário Cadastrado
    Quando fizer uma requisição do tipo GET para listar o usuário com as informações abaixo
      | email | testeAutomacao@email.com |
    Então devo receber a lista com o retorno dos usuários correspondentes

  Cenario: CT004 - Buscar um usuário com sucesso através do password
    Dado que eu possua um usuário Cadastrado
    Quando fizer uma requisição do tipo GET para listar o usuário com as informações abaixo
      | password | teste123 |
    Então devo receber a lista com o retorno dos usuários correspondentes

  Cenario: CT005 - Buscar um usuário com sucesso através do administrador
    Dado que eu possua um usuário Cadastrado
    Quando fizer uma requisição do tipo GET para listar o usuário com as informações abaixo
      | administrador | false |
    Então devo receber a lista com o retorno dos usuários correspondentes

