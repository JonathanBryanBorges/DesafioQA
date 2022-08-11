Feature: Executar o teste do Desafio QA

  @test01
  Scenario: Testar botoes
    Given Acesso ao link de teste
    When clico nos botoes one two e four
    Then valido a ausensia dos mesmos

  @test02
  Scenario: Testar botoes iframe
    Given Acesso ao link de teste
    When clico nos botoes one two e four iframe
    Then valido a ausensia dos botoes iframe

  @test03
  Scenario: Testar botao campos e imagem
    Given Acesso ao link de teste
    And preencho o campo firstName
    And clico no botao One
    When marco a optionThree
    And seleciono a opcao exampleTwo
    Then valido a imagen do selenium
