Feature: Account Login
  Scenario: Successful Login with Valid Credentials
    Given User is on the login page
    When User enters valid credentials
    And  User clicks on the login button
    Then Page logo text should be "Campaigns"
    When User hovers over the account icon
    Then Account Dropdown should be displayed
    When User clicks on logout button
    Then Sign in menu should be visible