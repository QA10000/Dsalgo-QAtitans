Feature:  Login Functionality
	
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
 
	  | username     | password    |
      | invaliduser  | invalidpass | 
      | 			 | 1234	       | 
      | 5678 		 |			   |
   Then The user should see an error message

Scenario: Verify the user recieves proper error message when giving different combination of username and password from the excel sheet.
Given The user is on the home page of the portal
When The user clicks login button after entering valid values from "Sheet2"
#Then user should see an error message

#Scenario Outline: Verify the data structures select box is present on the top left corner of the register page
#Then The user sees the data structures select box on the top left corner of the "Register" page

#Scenario Outline: Verify that link with "Register" label is displayed on the Register page
#Then The user sees "Register" link on  the top right corner of the  Register page

#Scenario Outline: Verify that link with "Signin" label is displayed on the Register page
#Then The user sees "Signin" link on  the top right corner of the Register page

#Scenario Outline: Verify the Login Page shows 'Register' link
#Then The user can see Register link on the Login Page

#Scenario Outline: Verify that user is able to land on Login Page
#Then The User land on Login Page

#Scenario Outline: Verify that user receives error message for all empty fields during Login
#Given The user is on the DS Algo Sign in Page
#When The user clicks Login button Without entering any text in  "Username" textbox
#Then An error message "Please fill out this field." appears below Username textbox

#Scenario Outline: Verify that user receives error message for all empty fields during Login
#Given The user is on the DS Algo Sign in Page
#When The user clicks Login button Without entering any text in  "Password" textbox
#Then An error message "Please fill out this field." appears below Password textbox

#Scenario Outline: Verify that user receives error message for invalid Username field during Login
#Given The user is on the DS Algo Sign in Page
#When The user clicks Login button after entering invalid username .
#Then The user should able to see an error message "Invalid username and password".

#Scenario Outline: Verify that user receives error message for invalid Password field during Login
#Given The user is on the DS Algo Sign in Page
#When The user clicks Login button after entering invalid Password .
#Then The user should able to see an error message "Invalid username and password".

#Scenario Outline: Verify that user able to land on Home page with valid Username and Password inputs
#Given The user is on the DS Algo Sign in Page
#When The user clicks Login button after entering valid username and valid password
#Then The user should land in Data Structure Home Page with message "You are logged in"

#Scenario Outline: Verify that URL is not accessible  with http
#Given The user is on the Browser
#When Runs the URL on the browser
#Then the Home Page should not load

#Scenario Outline: Verify  that URL is only accessible with https
#Given The user is on the Browser
#When Runs the URL on the browser
#Then The The user is redirected to the Home Page using https

#Scenario: Verify that "NumpyNinja" label is displayed on the top left corner of the Login page
#Then The user sees "NumpyNinja" label on the top left corner of the "Login" page

#Scenario: Verify the data structures select box is present on the top left corner of the register page
#Then The user sees the data structures select box on the top left corner of the "Login" page

#Scenario: Verify that link with "Register" label is displayed on the Login page
#Then The user sees "Register" link on  the top right corner of the  Login page

#Scenario: Verify that link with "Signin" label is displayed on the Login page
#Then The user sees "Signin" link on  the top right most corner of the Login page

#Scenario: Verify the Login Page shows 'Register' link
#Then The user can see Register link on the Login Page

#Scenario: Verify that user is able to land on Login Page
#Then The User land on Login Page

#Scenario: Verify that user receives error message for all empty fields during Login
#Given The user is on the DS Algo Sign in Page
#When The user clicks login button Without entering any text in  "Username" textbox
#Then An error message "Please fill out this field." appears below Username textbox

#Scenario: Verify that user receives error message for all empty fields during Login
#Given The user is on the DS Algo Sign in Page
#When The user clicks login button Without entering any text in  "Password" textbox
#Then An error message "Please fill out this field." appears below Password textbox

#Scenario: Verify that user receives error message for invalid Username field during Login
#Given The user is on the DS Algo Sign in Page
#When The user clicks login button after entering invalid username
#Then The user should able to see an error message "Invalid username and password".

#Scenario: Verify that user receives error message for invalid Password field during Login
#Given The user is on the DS Algo Sign in Page
#When The user clicks login button after entering invalid Password
#Then The user should able to see an error message "Invalid username and password".

#Scenario: Verify that user able to land on Home page with valid Username and Password inputs
#Given The user is on the DS Algo Sign in Page
#When The user clicks login button after entering valid username and valid password
#Then The user should land in Data Structure Home Page with message "You are logged in"

#Scenario: Verify that URL is not accessible  with http
#Given The user is on the Browser
#When Runs the URL on the browser
#Then The Home Page should not load

#Scenario: Verify  that URL is only accessible with https
#Given The user is on the Browser
#When Runs the URL on the browser
#Then The The user is redirected to the Home Page using https

