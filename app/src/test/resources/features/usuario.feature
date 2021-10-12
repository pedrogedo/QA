# language: pt

Funcionalidade: Gerenciamento de um usuário na PetStore

  COMO: Usuário do sistema da PetStore
  DESEJO: Cadastrar um usuário
  PARA: Que esse usuário possa ter acesso ao sistema


  Cenario: Criar um usuário na loja
    Quando Crio um usuario
    Entao O usuario e criado com sucesso


    @quarentine
    Cenario: Teste com acentos
      Quando faço um POST para /v3/user com os seguintes valores:
        | id         | 10                     |
        | username   | pedro                  |
        | firstName  | Pedro                  |
        | lastName   | Rosendo                |
        | email      | pedrorosendo@gmail.com |
        | password   | 12345                  |
        | phone      | 11999998888            |
        | userStatus | 1                      |
      Entao faço um GET para /v3/user/pedro, o usuário criado é retornado



