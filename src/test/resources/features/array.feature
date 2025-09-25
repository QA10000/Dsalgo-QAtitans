Feature: Array Functionality

  Background: 
    Given The user is on the DSAlgo portal
    When The user clicks "GetStarted" button on welcome page
    And The user logs in with valid username and password 
    Then The user lands on the home page of DSAlgo portal

  Scenario: Verify that user is able to navigate to "Array" Module page from array panel
    When user clicks "Getting Started" button in Array Panel
    Then the user should be directed to "Array" Module page

  Scenario Outline: Verify that user sees error message on entering invalid code in "try me" editor for "Arrays in Python" page
    Given The user is on Array Data Structure
    When The user clicks "<OptionOnArray>" link
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
    When The user clicks "<OptionOnArray>" link
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
    And The user write the valid "<code>" in Editor on practice question page and Click the Run Button
    Then The user should able to see "<result>" output in the console

    Examples: 
      | code                     | result          |
      | print('Hello QATitans!') | Hello QATitans! |

  Scenario: Verify that "NumpyNinja" label is displayed on the top left corner of the Array page module
    Given The user is on Array Data Structure
    Then The user sees "NumpyNinja" label on the top left corner of the "Array" page module

  Scenario: Verify the data structures dropdown is present on the top left corner of the Array page module
    Given The user is on Array Data Structure
    Then The user sees the "Data Structures" dropdown box on the top left corner of the "Array" page module
    
    Scenario: Verify that link with "Sign out" label is displayed on the Array page module
    Given The user is on Array Data Structure
   Then The user sees "Sign out" link on the top right most corner of the "Array" page module
   
   Scenario: Verify that link with username label is displayed on the Array page module
    Given The user is on Array Data Structure
   Then The user sees "Qatitans1" label on the top right corner of the "Array" page module
   
   Scenario Outline: Verify that user sees header labels on various links from Array page
    Given The user is on Array Data Structure
    When The user clicks "<OptionOnArray>" link
    Then The user sees "NumpyNinja" label on the top left corner of the "Array" page module
    And The user sees the "Data Structures" dropdown box on the top left corner of the "Array" page module
    And The user sees "Qatitans1" label on the top right corner of the "Array" page module
    And The user sees "Sign out" link on the top right most corner of the "Array" page module
   
    Examples: 
      | OptionOnArray             |
      | Arrays in Python          | 
      | Arrays using List         | 
      | Basic Operations in Lists |
      | Applications of Array     |  
         
       

    
    
