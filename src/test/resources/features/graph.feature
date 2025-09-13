Feature: Graph Page Functionality
  As a logged in user I should be able to access and use the Graph module

Background: 
    Given The user is on the DSAlgo portal
    When The user clicks "GetStarted" button on welcome page
    And The user logs in with valid username "qatitans1" and password "1@Chicago"
    Then The user lands on the home page of DSAlgo portal

 #scenario 1
 Scenario: User navigates to the "Graph" Data Structure page from the home page
    When user clicks "Getting Started" button in Graph Panel # Step 1
    Then The user lands on the "Graph" page # Step 2
    
Scenario Outline: Verify that user sees error message on entering invalid code in "try me" editor for "Graph Representations" page
    Given The user is on Graph Data Structure
    When The user clicks "<OptionOnGraph>" link on the Graph page
    And The user clicks "Try Here" button
    And run invalid code by clicking run button after entering "<code>" in try editor for graph module
    Then The user should see alert with  error message "<errorMessage>" on Array in Python page

    Examples: 
      | OptionOnGraph           | code | errorMessage                                    |
      | Graph				    | abcd | NameError: name 'abcd' is not defined on line 1 |
      | Graph Representations	| abcd | NameError: name 'abcd' is not defined on line 1 |
      
  Scenario Outline: Verify that user is able to see output for valid python code for "Graph Representations" page
    Given The user is on Graph Data Structure
    When The user clicks "<OptionOnGraph>" link on Graph page
    And The user clicks "Try Here" button on Graph page
    And run valid code by clicking run button after entering "<code>" in try editor
    Then The user should able to see "<message>" output in the console
      
    Examples: 
      | OptionOnGraph			| code                     | message         |
      | Graph			        | print('Hello QATitans!') | Hello QATitans! |
      | Graph Representations   | print('Hello QATitans!') | Hello QATitans! |
    
      
  Scenario: Verify that "Graph" label is displayed on the "Graph" page
    Given The user is on the DSAlgo Graph page
    When The user is on the "Graph" page
    Then The user sees "Graph" label on the "Graph" page    
      



