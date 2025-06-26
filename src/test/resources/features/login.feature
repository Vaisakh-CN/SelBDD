Feature: Login functionality

  Scenario: Successful login
  
    When user opens the login page
    And user enters username and password
    Then user should be logged in successfully
