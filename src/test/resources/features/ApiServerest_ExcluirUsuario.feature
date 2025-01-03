#language:pt

Funcionalidade: Validar funcionalidades de Exclusão de usuário da Api Serverest

  Cenario: CT001 - Excluir usuário com sucesso
    Dado que eu possua um usuário Cadastrado
    Quando fizer uma requisição do tipo DELETE para excluir esse usuário informando seu ID
    Então a API retorna o status code 200
    E devo receber a mensagem "Registro excluído com sucesso"

  Cenario: CT002 - Tentativa de Exclusão de usuário inexistente
    Quando fizer uma requisição do tipo DELETE para excluir um usuário inexistente
    Então a API retorna o status code 200
    E devo receber a mensagem "Nenhum registro excluído"

  Cenario: CT003 - Tentativa de Exclusão de usuário sem informar o ID
    Quando fizer uma requisição do tipo DELETE para excluir um usuário sem informar um ID
    Então a API retorna o status code 405
    E devo receber a mensagem "Não é possível realizar DELETE em /usuarios/. Acesse https://serverest.dev para ver as rotas disponíveis e como utilizá-las."