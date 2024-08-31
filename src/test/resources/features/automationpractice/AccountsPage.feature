Feature:Account Page Feature

  Background: User is in Login Page
    Given user has already logged in to application
      |username|password|
      |tester@email.com|tester@best|

    @Accounts
  Scenario:Accounts page title
    Given user is on Accounts page
    When user gets the title of the page
    Then page title should be "My account - My Shop"

  @Accounts
  Scenario: Accounts section count
    Given user is on Accounts page
    Then user gets accounts section
      |ADD MY FIRST ADDRESS|
      |ORDER HISTORY AND DETAILS  |
      |MY CREDIT SLIPS|
      |MY ADDRESSES         |
      |MY PERSONAL INFORMATION         |
      |Home|
    And accounts section count should be 6

