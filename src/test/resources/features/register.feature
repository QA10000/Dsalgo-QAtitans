Feature: User Registration
  
  As a new user
  I want to register with a username and password
  So that I can log in to the DSALgo portal

  Background: 
    Given The user is on the DSAlgo portal
    When The user clicks "GetStarted" button on welcome page
    Then The user lands on the home page of DSAlgo portal

  Scenario: Verify that user is able to navigate to Register page
    When The user clicks on the Register link on home page
    Then The user lands on Register page

  Scenario Outline: Verify the user receives proper error message when giving different password and password confirmation 
    Given The user is on the register page of the portal
    When The user submits the registration form with mismatched passwords:
      | username   | password    | confirmpassword |
      | TestUser01 | Test@1234   | Test@12346      |
      |  aaa       | invaliduser | invalidpass     |
      | 77777777   | 77777777    |  7777777        |
      | TestUser04 |  www        | Test@12349      |
      | TestUser04 | @#$%#$#@    | Test@12349      |
    Then The user sees "password_mismatch:The two password fields didn’t match." error message

  Scenario Outline: Verify the user is landing on the DsAlgo home portal after entering valid username and password
    Given The user is on the register page of the portal
    When The user clicks Register button after entering valid values from "<Sheet>"
    Then The user lands on the DSAlgo Home portal with Success Message "New Account Created. You are logged in as <username>"

    Examples: 
      | Sheet  |
      | Sheet1 |
      
    Scenario: Verify that "NumpyNinja" label is displayed on the top left most corner of the Register module page
    Given The user is on the register page of the portal
    Then The user sees "NumpyNinja" label on the top left corner of the Register page

  Scenario: Verify the data structures select box is present on the top left corner of the register module page
    Given The user is on the register page of the portal
    Then The user sees the "Data Structures" select box on the top left corner of the Register module page

  Scenario: Verify that link with "Register" label is displayed on the Register page
    Given The user is on the register page of the portal
    Then The user sees "Register" link on  the top right corner of the  Register page

  Scenario: Verify that link with "Signin" label is displayed on the Register page
    Given The user is on the register page of the portal
    Then The user sees "Sign in" link on the top right most corner of the Register page
