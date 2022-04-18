Feature: Web login
  Scenario: Login to homepage with user incorrect
    Given User go to page
    When User login into application with <email> and <password>
    Then the home page is closed

