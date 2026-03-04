Feature: Login functionality

  @smoke
  Scenario: Verify login with valid credentials
    Given User launches the browser
    And User navigates to login page
    When User enters valid credentials
    Then User should land on dashboard page


  Scenario: Verify login with invalid credentials
    Given user launches the browser
    And user navigates to login page
    When user enters invalid credentials
    Then user should not land on dashboard page  
