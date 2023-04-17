Feature: Scenario Outline Example
	@Outline
  Scenario Outline: 
    When Login with "<username>" and "<password>"
    And Click on the login button
    Then Validate that "<username>" is displayed
    And We want to say Bye "<fullname>"

    Examples: 
      | username | password | fullname      |
      | Emine    | e1234    | Emine Karakaya |
      | Volkan   | v1234    | Volkan Gedik   |
      | Harun    | h1234    | Harun Bicakci  |
