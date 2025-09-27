Feature: Login Functionality

  Background: 
    Given The user is on the DSAlgo portal
    When The user clicks "GetStarted" button on welcome page
    Then The user lands on the home page of DSAlgo portal
    
  Scenario: Verify that user is able to navigate to Login page
    When The user clicks on the Signin link on home page
    Then The user lands on the "Login" page
 
 
  Scenario: Verify the user is landing on the DsAlgo home portal after entering valid username and password
    And The user logs in with valid username and password 
    Then The user lands on the DS Algo Home portal with success message "You are logged in"

  Scenario: Verify the user is landing on the DsAlgo home portal after entering valid username and password
    When The user clicks login button after entering valid values from "Sheet1"
    Then The user lands on the DS Algo Home portal with success message "You are logged in"


Scenario: Verify the user receives proper error message when giving different combination of username and password
    Given The user is on the Login page of the portal
    When The user enters invalid username and password in the textboxes
      | username    | password    |
      | invaliduser | invalidpass |
      |             |        1234 |
      |        5678 |             |
	Then The user should see an error message 	
    
Scenario: Verify the user recieves proper error message when giving different combination of username and password from the excel sheet.
When The user clicks login button after entering valid values from "Sheet2"
Then The user should see an error message

Scenario: Verify that "NumpyNinja" label is displayed on the top left corner of the Login page
When The user clicks on the Signin link on home page
Then The user sees "NumpyNinja" label on the top left corner of the "Login" page

Scenario: Verify the data structures dropdown is present on the top left corner of the Login page
When The user clicks on the Signin link on home page
Then The user sees the "Data Structures" dropdown box on the top left corner of the "Login" page

Scenario: Verify the Login Page shows 'Register' link
When The user clicks on the Signin link on home page
Then The user sees the "Register" link on the top right corner of the "Login" page

Scenario: Verify that link with "Sign in" label is displayed on the Login page
Then The user sees "Sign in" link on  the top right most corner of the Login page

 
    