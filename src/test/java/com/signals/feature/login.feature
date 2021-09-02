Feature: Login to the Signals Notebook


  Scenario: User tries to login to the Signals Notebook
    When User open the signals notebook "training" URL
    And User enters the username as "User1"
    And User enters the password as "User1"
    Then User logs into the signals notebook

  @all @login
  Scenario: User tries to login to the Signals Notebook
    When User open the signals notebook "training" URL
    And User enters the username and password from email
    Then User logs into the signals notebook