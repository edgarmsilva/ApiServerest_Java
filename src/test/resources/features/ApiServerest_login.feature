#language:pt

Funcionalidade: Validar Login da Api Serverest

  Cenario: CT001 - Login com sucesso
    Dado que eu possua um usuário Cadastrado
    Quando o usuário "testeAutomacao@email.com" fizer login com a senha "teste123"
    Então a API retorna o status code 200
    Então devo receber a mensagem "Login realizado com sucesso"
    E o token de autorização

  Cenario: CT002 - Tentativa de Login sem sucesso
    Quando o usuário "teste@aaaa.com" fizer login com a senha "aaaaa"
    Então a API retorna o status code 401
    E devo receber a mensagem "Email e/ou senha inválidos"

  Cenario: CT003 - Tentativa de Login sem enviar email
    Quando o usuário "" fizer login com a senha "teste123"
    Então a API retorna o status code 400
    E devo receber a mensagem de erro "email" "email não pode ficar em branco"

  Cenario: CT004 - Tentativa de Login sem enviar senha
    Quando o usuário "edgar.teste@teste.com" fizer login com a senha ""
    Então a API retorna o status code 400
    E devo receber a mensagem de erro "password" "password não pode ficar em branco"

  Cenario: CT004 - Tentativa de Login sem enviar email e senha
    Quando o usuário "" fizer login com a senha ""
    Então a API retorna o status code 400
    E devo receber a mensagem de erro correspondente
      | password | password não pode ficar em branco |
      | email    | email não pode ficar em branco    |