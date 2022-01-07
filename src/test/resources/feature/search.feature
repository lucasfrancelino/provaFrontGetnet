Feature: Search for Superget

  @tag1
  Scenario: Validate modal superget
    Given that Im a user that Im looking to know about Superget
    When I search for superget
    Then I validate that the modal with the message 'Como acesso a minha conta SuperGet?' is being displayed    