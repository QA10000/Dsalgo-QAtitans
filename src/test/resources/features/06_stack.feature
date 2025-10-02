Feature: Stack Functionality

Background: 
    Given The user is on the DSAlgo portal
    When The user clicks "GetStarted" button on welcome page
    And The user logs in with valid username and password 
    Then The user lands on the home page of DSAlgo portal
    
	Scenario: Verify that user is able to navigate to "Stack - Introduction" page	
		Given The user is on the home page after login	
		When The user clicks the "Getting Started" button for Stack module on Home page
		Then The user lands on "Stack" page

	Scenario: Verify the user is able to navigate to Operations in Stack page from Stack page and verify all links are present
		Given The user is on Stack page after login
		When  The user clicks on the Operations in Stack link on the Stack page
		Then All expected navigation links should be displayed

	Scenario: Verify the user is able to navigate to Implementation page from Stack page and verify all links are present
		Given The user is on Stack page after login
		When  The user clicks on the Implementation link on the Stack page
		Then All expected navigation links should be displayed

	Scenario: Verify the user is able to navigate to Applications page from Stack page and verify all links are present
		Given The user is on Stack page after login
		When  The user clicks on the Applications link on the Stack page
		Then All expected navigation links should be displayed

	Scenario Outline: Verify that user sees error message on entering invalid code in "try me" editor for "Operations in Stack" page
		Given The user is on Stack page after login
		When The user clicks on the "<OptionOnStack>" link on Stack page 
		And The user clicks "Try Here" button on "<OptionOnStack>" page
		And The user clicks Run button after entering valid "<Code>" in try editor 
		Then The user should see alert with error message "<ErrorMessage>" on TryEditor
		Examples:    
		| OptionOnStack             | Code | ErrorMessage                                    |
		| Operations in Stack       | Abcd | NameError: name 'Abcd' is not defined on line 1 |
		| Implementation            | Abcd | NameError: name 'Abcd' is not defined on line 1 |
		| Applications              | Abcd | NameError: name 'Abcd' is not defined on line 1 |

	Scenario Outline: Verify that user is able to see output for valid python code for "Stack" page
		Given The user is on Stack page after login
		And The user clicks on the "<OptionOnStack>" link on Stack page
		And The user clicks "Try Here" button on "<OptionOnStack>" page
		And The user clicks Run button after entering valid "<code>" in try editor
		Then The user should see the output "<message>" on TryEditor
		Examples: 
		| OptionOnStack             | code                      | message     |
		| Operations in Stack       | print('Hello World')      | Hello World |
		| Implementation            | print('Hello World')      | Hello World |
		| Applications              | print('Hello World')      | Hello World |
