Feature: Experiment signing and closing

  @sign
Scenario Outline: User is signing an closing an experiment after creating a new experiment
When User open the signals notebook "training" URL
And User enters the username and password from email
And User logs into the signals notebook
And User selects on the add new experiment button
And User selects the template as "Automation_Template" for the creation of experiment
And User enters the description for the creation of new Experiment
  And User enters the name for the new Experiment
And User selects the notebook as "My first Notebook" for the creation of experiment
And User clicks on the creation of experiment
And User selects on the signing button
  Then User completes the sign in process according to the "<signintype>"
    And User enters the credentials and logs in the application
    Then User verifies the signing completion message

  Examples:

    | signintype |
    | signandclose |
    | signandkeepopen |
