
    
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

  Scenario Outline: Verify that user sees error message on entering invalid code in "try me" editor for "Arrays in Python" page
    Given The user is on Array Data Structure
    And The user clicks "<OptionOnArray>" link
    And The user clicks "Try Here" button in Arrays in Python
    And run invalid code by clicking run button after entering "<code>" in try editor
    Then The user should see alert with  error message "<errorMessage>" on Array in Python page

    Examples: 
      | OptionOnArray             | code | errorMessage                                    |
      | Arrays in Python          | abcd | NameError: name 'abcd' is not defined on line 1 |
      | Arrays using List         | abcd | NameError: name 'abcd' is not defined on line 1 |
      | Basic Operations in Lists | abcd | NameError: name 'abcd' is not defined on line 1 |
      | Applications of Array     | abcd | NameError: name 'abcd' is not defined on line 1 |

  Scenario Outline: Verify that user is able to see output for valid python code for "Arrays in Python" page
    Given The user is on Array Data Structure
    And The user clicks "<OptionOnArray>" link
    And The user clicks "Try Here" button in Arrays in Python
    And run valid code by clicking run button after entering "<code>" in try editor
    Then The user should able to see "<message>" output in the console

    Examples: 
      | OptionOnArray             | code                     | message         |
      | Arrays in Python          | print('Hello QATitans!') | Hello QATitans! |
      | Arrays using List         | print('Hello QATitans!') | Hello QATitans! |
      | Basic Operations in Lists | print('Hello QATitans!') | Hello QATitans! |
      | Applications of Array     | print('Hello QATitans!') | Hello QATitans! |

   Scenario Outline: Verify that user is able to navigate to "Search the array" Page from Practice question page of "Arrays in Python" page
     Given The user is on the "Practic Questions" page
     When The user clicks the "Search the array" link
     When The user write the valid "<code>" in Editor on practice question page and Click the Run Button
     Then The user should able to see "<result>" output in the console
     
     Examples:
     |code                                                              |result          |
     |print('Hello QATitans!')                                          |Hello QATitans! |        
     
   #Scenario: Verify that user is able to run valid python code for "Search the array" question // may be we will not need it 
    # Given The user is on the practice question editor
     #When The user write the valid code in Editor and Click the Run Button

   #Scenario: Verify that "NumpyNinja" label is displayed on the top left corner of the Array page
     #Then The user see s"NumpyNinja" label on the top left corner of the "Array" page

   #Scenario: Verify the data structures select box is present on the top left corner of the Array page
    # Then The user sees the data structures select box on the top left corner of the "Array" page

   #Scenario: Verify that "Array" label is displayed on the Array page
    # Then The user sees "Array" label on  the top right corner of the  Array page

  # Scenario: Verify that link with "Signin" label is displayed on the Array page
     #Then The user sees "Signin" link on  the top right corner of the Array page

   #Scenario: Verify the Array Page shows 'Array' link
     #Then The user can see Array link on the Array Page

   #Scenario: Verify that user is able to land on Array Page
     #Then The User land on Array Page
    
  
    
  
