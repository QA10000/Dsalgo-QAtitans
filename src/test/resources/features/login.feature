Feature: Login Functionality

  Background: 
    #Given The user is on the DSAlgo portal
    #When The user clicks "GetStarted" button on welcome page
    #Then The user lands on the home page of DSAlgo portal
    Given The user is on the DSAlgo portal
    When The user clicks "GetStarted" button on welcome page
    Then The user lands on the home page of DSAlgo portal
    
  Scenario: Verify that user is able to navigate to Login page
   # Given The user is on the home page of the portal
    When The user clicks on the Signin link on home page
    Then The user lands on the "Login" page
 
 
  Scenario: Verify the user is landing on the DsAlgo home portal after entering valid username and password
  #  Given The user is on the home page of the portal
    When The user clicks login button after entering valid username as "qatitans1" and password as "1@Chicago"
    Then The user lands on the DS Algo Home portal with success message "You are logged in"

  Scenario: Verify the user is landing on the DsAlgo home portal after entering valid username and password
  #  Given The user is on the home page of the portal
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
#Given The user is on the home page of the portal
When The user clicks login button after entering valid values from "Sheet2"
#Then user should see an error message

#Scenario Outline: Verify that URL is not accessible  with http
#Given The user is on the Browser
#When Runs the URL on the browser
#Then the Home Page should not load

#Scenario Outline: Verify  that URL is only accessible with https
#Given The user is on the Browser
#When Runs the URL on the browser
#Then The The user is redirected to the Home Page using https

Scenario: Verify that "NumpyNinja" label is displayed on the top left corner of the Login page
#Given The user is on the home page of the portal
When The user clicks on the Signin link on home page
Then The user sees "NumpyNinja" label on the top left corner of the "Login" page

Scenario: Verify the data structures dropdown is present on the top left corner of the Login page
#Given The user is on the home page of the portal
When The user clicks on the Signin link on home page
Then The user sees the "Data Structures" dropdown box on the top left corner of the "Login" page

Scenario: Verify the Login Page shows 'Register' link
#Given The user is on the home page of the portal
When The user clicks on the Signin link on home page
Then The user sees the "Register" link on the top right corner of the "Login" page

Scenario: Verify that link with "Sign in" label is displayed on the Login page
#Given The user is on the home page of the portal
Then The user sees "Sign in" link on  the top right most corner of the Login page

#Scenario: Verify that URL is not accessible  with http
 # Given The user opens a web browser
 # When The user enters the application URL with "http" instead of "https"
 # Then The Home Page should not load

 # Scenario: Verify the user recieves proper error message when giving different combination of username and password from the excel sheet.
 #   Given The user is on the home page of the portal
  #  When The user clicks login button after entering valid values from "Sheet2"

    