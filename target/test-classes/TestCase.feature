@tag
Feature: login
 
  @tag1
  Scenario: login with valid credentials
    Given open the browser and enter the valid url 
    When user enters valid username
    And user enters valid password
    And click login button
    Then user should in homepage of the application

    