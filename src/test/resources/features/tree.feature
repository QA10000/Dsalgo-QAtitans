Feature: Tree Page Functionality
  As a logged in user I should be able to access and use the Tree module

  Background: 
    Given The user is on the DSAlgo portal
    When The user clicks "GetStarted" button on welcome page
    And The user logs in with valid username "qatitans1" and password "1@Chicago"
    Then The user lands on the home page of DSAlgo portal

  Scenario: User navigates to the "Tree" Data Structure page from the home page
    When user clicks "Getting Started" button in tree Panel
    Then The user lands on the "Tree" page

  Scenario Outline: Verify that user sees error message on entering invalid code in "try me" editor for "Overview of Trees" page
    Given The user is on Tree Data Structure
    When The user clicks "<OptionOnTree>" link on the tree page
    And The user clicks "Try Here" button
    And run invalid code by clicking run button after entering "<code>" in try editor for tree module
    Then The user should see alert with  error message "<errorMessage>" on Array in Python page

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
      
  Scenario: Verify that "Tree" label is displayed on the "Tree" page
    Given The user is on the DSAlgo Tree page
    When The user is on the "Tree" page
    Then The user sees "Tree" label on the "Tree" page
