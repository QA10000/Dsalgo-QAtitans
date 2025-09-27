Feature:Home Page Functionality

  Background : 
    Given The user is on the DSAlgo portal
    When The user clicks "GetStarted button on welcome page
    Then The user lands on the home page of DSAlgo portal

  Scenario: Verify that "NumpyNinja" label is displayed on the top left corner of the Home page
    Then The user see s"NumpyNinja" label on the top left corner of the "Home" page

  Scenario: Verify the data structures select box is present on the top left corner of the Home page
    Then The user sees the data structures select box on the top left corner of the "Home" page

  Scenario: Verify that link with "Home" label is displayed on the Home page
    Then The user sees "Home" link on  the top right corner of the  Home page

  Scenario: Verify that link with "Signin" label is displayed on the Home page
    Then The user sees "Signin" link on  the top right corner of the Home page

Scenario: Verify that link with "Register" label is displayed on the Home page
    Then The user sees "Register" link on  the top right corner of the Home page

Scenario: Verify that user able to see warning message on clicking "Get Started" buttons of "Data Structure-Introduction" on the home page without Sign in
Given The user is in the DS Algo Home Page
When The User 'Get Started' button present under 'Data Structure Introduction' box
Then The user should able to see an warning message "You are not logged in"

Scenario: Verify that user able to see warning message on clicking "Get Started" buttons of "Array" on the home page without Sign in
Given The user is in the DS Algo Home Page
When The User 'Get Started' button present under 'Array' box
Then The user should able to see an warning message "You are not logged in"

Scenario: Verify that user able to see warning message on clicking "Get Started" buttons of "Linked List" on the home page without Sign in
Given The user is in the DS Algo Home Page
When The User 'Get Started' button present under 'Linked List' box
Then The user should able to see an warning message "You are not logged in"

Scenario: Verify that user able to see warning message on clicking "Get Started" buttons of "Stack" on the home page without Sign in
Given The user is in the DS Algo Home Page
When The User 'Get Started' button present under 'Stack' box
Then The user should able to see an warning message "You are not logged in"

Scenario: Verify that user able to see warning message on clicking "Get Started" buttons of "Queue" on the home page without Sign in
Given The user is in the DS Algo Home Page
When The User 'Get Started' button present under 'Queue' box
Then The user should able to see an warning message "You are not logged in"

Scenario: Verify that user able to see warning message on clicking "Get Started" buttons of "Tree" on the home page without Sign in
Given The user is in the DS Algo Home Page
When The User 'Get Started' button present under 'Tree' box
Then The user should able to see an warning message "You are not logged in"

Scenario: Verify that user able to see warning message on clicking "Get Started" buttons of "Graph" on the home page without Sign in
Given The user is in the DS Algo Home Page
When The User 'Get Started' button present under 'Graph' box
Then The user should able to see an warning message "You are not logged in"


Scenario: Verify learning modules are visible on home page
Given the user is on the DS Algo Home Page
When the user has not logged in
Then the user should see the following learning modules with "Get Started" buttons:
  | Module Name   |
  | Array         |
  | Linked List   |
  | Stack         |
  | Queue         |
  | Tree          |
  | Graph         |



