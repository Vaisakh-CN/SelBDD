Feature: Login functionality

  Scenario: Successful login
    Given user launches the browser
    When user opens the login page
    And user enters username and password
    Then user should be logged in successfully
