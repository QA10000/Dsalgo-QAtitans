Feature: Tree Page Functionality
  As a logged in user I should be able to access and use the Tree module

  Background: 
    Given The user is on the DSAlgo portal
    When The user clicks "GetStarted" button on welcome page
    And The user logs in with valid username and password 
    Then The user lands on the home page of DSAlgo portal

  Scenario: User navigates to the "Tree" Data Structure page from the home page
    When user clicks "Getting Started" button in tree Panel
    Then The user lands on the "Tree" page

  Scenario Outline: Verify that user sees error message on entering invalid code in "try me" editor for "Overview of Trees" page
    Given The user is on Tree Data Structure
    When The user clicks "<OptionOnTree>" link on the tree page
    And The user clicks "Try Here" button
    And run invalid code by clicking run button after entering "<code>" in try editor for tree module
    Then The user should see alert with  error message "<errorMessage>" on Tree module page

    Examples: 
      | OptionOnTree            | code | errorMessage                                    |
      | Overview of Trees       | abcd | NameError: name 'abcd' is not defined on line 1 |
      | Terminologies           | abcd | NameError: name 'abcd' is not defined on line 1 |
      | Types of Trees          | abcd | NameError: name 'abcd' is not defined on line 1 |
      | Tree Traversals         | abcd | NameError: name 'abcd' is not defined on line 1 |
      | Traversals-Illustration | abcd | NameError: name 'abcd' is not defined on line 1 |
      | Binary Trees            | abcd | NameError: name 'abcd' is not defined on line 1 |
      | Types of Binary Trees   | abcd | NameError: name 'abcd' is not defined on line 1 |
      
    Scenario Outline: Verify that user is able to see output for valid python code for "Overview of Trees" page
    Given The user is on Tree Data Structure
    When The user clicks "<OptionOnTree>" link on tree page
    And The user clicks "Try Here" button on tree page
    And run valid code by clicking run button after entering "<code>" in try editor
    Then The user should able to see "<message>" output in the console
      
       Examples: 
      | OptionOnTree              | code                     | message         |
      | Overview of Trees         | print('Hello QATitans!') | Hello QATitans! |
      | Terminologies             | print('Hello QATitans!') | Hello QATitans! |
      | Types of Trees            | print('Hello QATitans!') | Hello QATitans! |
      | Tree Traversals           | print('Hello QATitans!') | Hello QATitans! |
      | Traversals-Illustration   | print('Hello QATitans!') | Hello QATitans! |
      | Binary Trees              | print('Hello QATitans!') | Hello QATitans! |
      | Types of Binary Trees     | print('Hello QATitans!') | Hello QATitans! |
      
 Scenario: Verify that "NumpyNinja" label is displayed on the top left corner of the Tree page module
    Given The user is on Tree Data Structure
    Then The user sees "NumpyNinja" label on the top left corner of the "Tree" page module

  Scenario: Verify the data structures dropdown is present on the top left corner of the Tree page module
    Given The user is on Tree Data Structure
    Then The user sees the "Data Structures" dropdown box on the top left corner of the "Tree" page module
    
    Scenario: Verify that link with "Sign out" label is displayed on the Tree page module
    Given The user is on Tree Data Structure
   Then The user sees "Sign out" link on the top right most corner of the "Tree" page for tree module
   
   Scenario: Verify that link with username label is displayed on the Tree page module
    Given The user is on Tree Data Structure
   Then The user sees "Qatitans1" label on the top right corner of the "Tree" page for tree module
   
   
   Scenario Outline: Verify that user sees header labels on various links from Tree page
    Given The user is on Tree Data Structure
    When The user clicks "<OptionOnTree>" link
    Then The user sees "NumpyNinja" label on the top left corner of the "Tree" page module
    And The user sees the "Data Structures" dropdown box on the top left corner of the "Tree" page module
    And The user sees "Qatitans1" label on the top right corner of the "Tree" page module
    And The user sees "Sign out" link on the top right most corner of the "Tree" page module
   
    Examples: 
      | OptionOnTree            | 
      | Overview of Trees       |
      | Terminologies           | 
      | Types of Trees          | 
      | Tree Traversals         | 
      | Traversals-Illustration | 
      | Binary Trees            | 
      | Types of Binary Trees   |  
    
