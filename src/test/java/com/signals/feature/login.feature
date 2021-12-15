Feature: Login to the Signals Notebook

  @all @login
  Scenario Outline: User tries to login to the Signals Notebook
    When User open the signals notebook "training" URL
    And User enters the "<username>" and "<password>" from email
    Then User logs into the signals notebook
    Then User verifies the dashboard page in the Signals notebook
    Then User logs out of the application


    Examples:

      | username | password |
      | users | 1 |
      | users | 2 |
