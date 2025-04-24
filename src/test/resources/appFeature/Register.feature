Feature: Register Functionality
  Verify the register functionality of the application.

  Scenario: Successful register
    Given I am on the register page
    When I enter valid data in all the fields
    Then Account is created