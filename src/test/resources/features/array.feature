Feature: Array Functionality
  As a logged in user I should be able to access and use array module

  Background: 
    Given The user is on the DSAlgo portal
    When The user clicks "GetStarted button on welcome page"
    Then The user lands on the home page of DSAlgo portal
    
  Scenario: Verify that user is not able to navigate to "Array" Module
    When The user clicks "Get Started" button for the Array
    Then the user should not be directed to "Array" Module page but a message "You are not logged in" should be displayed at the top of the homepage.

  Scenario: Verify that user is able to navigate to "Array" Module page from array panel
   Given The user signed in to dsAlgo Portal
    When user clicks "Getting Started" button in Array Panel
    Then the user should be directed to "Array" Module page

  Scenario: Verify that user is able to navigate to "Array" Module page using Data Structure dropdown
    When user selects "Array" item from "Data Structures" drop down
    Then the user should be directed to "Array" Module page

  Scenario: Verify that user sees error message on entering invalid code in "try me" editor for "Arrays in Python" page
   Given The user is on Array Data Structure
  And The user clicks "Arrays in Python" link
  And The user clicks "Try Here" button in Arrays in Python
  And run invalid code by clicking run button after entering "abcd" in try editor
  Then The user should see alert with  error message "NameError: name 'abcd' is not defined on line 1" on Array in Python page
  
  #Scenario Outline: Verify that user sees error message on entering invalid code in "try me" editor for "Arrays in Python" page
    #Given The user is on Array Data Structure
    #And The user clicks <OptionOnArray> link
    #And The user clicks "Try Here" button in Arrays in Python
    #And run invalid code by clicking run button after entering <code> in try editor
    #Then The user should see alert with  error message <errorMessage> on Array in Python page 

    #Examples: 
     # | OptionOnArray             | code | errorMessage                                    |
     # | Arrays in Python          | abcd | NameError: name 'abcd' is not defined on line 1 |
      #| Arrays using List         | abcd | NameError: name 'abcd' is not defined on line 1 |
      #| Basic Operations in Lists | abcd | NameError: name 'abcd' is not defined on line 1 |
      #| Applications of Array     | abcd | NameError: name 'abcd' is not defined on line 1 |
