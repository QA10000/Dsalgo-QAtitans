Feature: Login Functionality

  Background: 
    Given The user is on the DSAlgo portal
    When The user clicks "GetStarted" button on welcome page
    Then The user lands on the home page of DSAlgo portal

  Scenario: Verify that user is able to navigate to Login page
    Given The user is on the home page of the portal
    When The user clicks on the Signin link on home page
    Then The user lands on the "Login" page

  Scenario: Verify the user is landing on the DsAlgo home portal after entering valid username and password
    Given The user is on the home page of the portal
    When The user clicks login button after entering valid username as "qatitans1" and password as "1@Chicago"
    Then The user lands on the DS Algo Home portal with success message "You are logged in"

  Scenario: Verify the user is landing on the DsAlgo home portal after entering valid username and password
    Given The user is on the home page of the portal
    When The user clicks login button after entering valid values from "Sheet1"
    Then The user lands on the DS Algo Home portal with success message "You are logged in"

  Scenario: 
    Verify the user receives proper error message when giving different combination of username and password

    Given The user is on the Login page of the portal
    When The user enters invalid username and password in the textboxes
      | username    | password    |
      | invaliduser | invalidpass |
      |             |        1234 |
      |        5678 |             |
    Then The user should see an error message

  Scenario: Verify the user recieves proper error message when giving different combination of username and password from the excel sheet.
    Given The user is on the home page of the portal
    When The user clicks login button after entering valid values from "Sheet2"
