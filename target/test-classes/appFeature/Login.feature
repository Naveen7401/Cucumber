Feature: Login Functionality

@validlogin
  Scenario: Successful login
    Given I am on the login page
    When I enter valid credentials
    Then I should be redirected to the dashboard
    
 
    
    @invalidlogin
  Scenario: Invalid login
    When I enter invalid credentials
    Then Error message should appear
    
    
   
  @multipleLogin
  Scenario Outline: Successful login with valid credentials
    Given Redirected to login page
    When I enter "<username>" and "<password>"
    Then I should see a welcome message

    Examples:
      | username   | password   |
      | user1      | pass1      |
      | user2      | pass2      |
      | admin      | adminpass  | 