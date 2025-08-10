Feature: User Registration

  As a new user
  I want to register with a username and password
  So that I can log in to the application

  Background:
    Given I am on the registration page

  Scenario: Successful registration with valid credentials
    When I enter username "testuser1"
    And I enter password "Password123"
    And I confirm password "Password123"
    And I click the Register button
    Then I should see a success message "New Account Created."