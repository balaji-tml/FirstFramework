Feature: Login page feature

  Background:user is on login page
    Given user is on login page

  @Login
  Scenario: Login page title
    When user gets the title of the login page
    Then login page title should be "Login - My Shop"

  @Login
  Scenario: Forgot Password Link
    Then forgot your password link should be displayed

  @Login
  Scenario: Login with correct credentisls
    When user enters username "tester@email.com"
    And user enters password "tester@best"
    And user clicks on Login button
    Then user gets the title of the home page
    And home page title should be "My account - My Shop"



