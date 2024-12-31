#language:pt

@ValidaDadosProduto
Funcionalidade:

  Cenario: CT001 - Validar Login com sucesso
    Quando o usuário "edgar.teste@teste.com" fizer login com a senha "teste123"
    Então deve receber a mensagem "Login realizado com sucesso"
    E o token de autorização

  Cenario: CT002 - Validar Tentativa de Login sem sucesso
    Quando o usuário "teste@aaaa.com" fizer login com a senha "aaaaa"
    Então deve receber a mensagem "Email e/ou senha inválidos"

  Cenario: CT003 - Validar Tentativa de Login sem enviar email
    Quando o usuário "" fizer login com a senha "teste123"
    Então deve receber a mensagem de erro "email" "email não pode ficar em branco"

  Cenario: CT004 - Validar Tentativa de Login sem enviar senha
    Quando o usuário "edgar.teste@teste.com" fizer login com a senha ""
    Então deve receber a mensagem de erro "password" "password não pode ficar em branco"

  Cenario: CT004 - Validar Tentativa de Login sem enviar email e senha
    Quando o usuário "" fizer login com a senha ""
    Então deve receber as mensagens de erro:
      | password | "password não pode ficar em branco" |
      | email    | email não pode ficar em branco      |