Feature:LinkedList Functionality

Background: 
	Given The user is on the DSAlgo portal
	When The user clicks "GetStarted" button on welcome page
	And The user logs in with valid username and password 
	Then The user lands on the home page of DSAlgo portal

	Scenario Outline: Verify the user is able to see all the headers/labels on the Linked List Page
		When The user clicks the "Getting Started" button for Linked List module on Home page
		Then The user should see the following "<Headers>" on the Linked List Page 

		Examples:
		| Headers       |
		| Linked List   |
		| Topics Covered|

			  
	Scenario: Verify the user is able to navigate to "Linked List" Data Structure page using dropdown on home page
		Given The user is on the home page after login
		When  The user select Linked List item from the drop down menu
		Then All expected navigation links should be displayed on Linked List Page

	Scenario: Verify the user is able to navigate to "Introduction" page from "Linked List" page verify all links are present
		Given The user is on Linked List page after login
		When  The user clicks on the "Introduction" link on the Linked List page
		Then All expected headers and navigation links should be displayed

	Scenario: Verify the user is able to navigate to "Creating Linked LIst" page from "Linked List" page and verify all links are present
		Given The user is on Linked List page after login
		When  The user clicks on the "Creating Linked LIst" link on the Linked List page
		Then All expected headers and navigation links should be displayed

	Scenario: Verify the user is able to navigate to "Types of Linked List" page from "Linked List" page and verify all links are present
		Given The user is on Linked List page after login
		When  The user clicks on the "Types of Linked List" link on the Linked List page
		Then All expected headers and navigation links should be displayed

	Scenario: Verify the user is able to navigate to "Implement Linked List in Python" page from "Linked List" page and verify all links are present
		Given The user is on Linked List page after login
		When  The user clicks on the "Implement Linked List in Python" link on the Linked List page
		Then All expected headers and navigation links should be displayed

	Scenario: Verify the user is able to navigate to "Traversal" page from "Linked List" page
		Given The user is on Linked List page after login
		When  The user clicks on the "Traversal" link on the Linked List page
		Then All expected headers and navigation links should be displayed

	Scenario: Verify the user is able to navigate to "Insertion" page from "Linked List" page
		Given The user is on Linked List page after login
		When  The user clicks on the "Insertion" link on the Linked List page
		Then All expected headers and navigation links should be displayed

	Scenario: Verify the user is able to navigate to "Deletion" page from "Linked List" page
		Given The user is on Linked List page after login
		When  The user clicks on the "Deletion" link on the Linked List page
		Then All expected headers and navigation links should be displayed


	Scenario Outline: Verify the user sees the output on clicking "Run" button after entering valid code for "Creating LinkedLIst" page.
		Given The user is on Linked List page after login
		When The user clicks on the "<OptionOnLinkedList>" link  
		And The user clicks "Try Here" button on "<OptionOnLinkedList>" page
		And The user clicks Run button after entering valid "<code>" in try editor 
		Then The user should see the output "<message>" on TryEditor

		Examples:
		| OptionOnLinkedList              | code                                                  | message                                      |
		| Introduction                    | print('Hello World!Introduction')                     | Hello World!Introduction                     |
		| Creating Linked LIst            | print('Hello World! Creating Linked LIst')            | Hello World! Creating Linked LIst            |
		| Types of Linked List            | print('Hello World! Types of Linked List')            | Hello World! Types of Linked List            | 
		| Implement Linked List in Python | print('Hello World! Implement Linked List in Python') | Hello World! Implement Linked List in Python |
		| Traversal                       | print('Hello World! Traversal')                       | Hello World! Traversal                       |   
		| Insertion                       | print('Hello World! Insertion')                       | Hello World! Insertion                       |  
		| Deletion                        | print('Hello World! Deletion')                        | Hello World! Deletion                        |


	Scenario Outline: Verify the user see an error message on clicking "Run" button after entering invalid code for "<OptionOnLinkedList>" page.  
		Given The user is on Linked List page after login
		When The user clicks on the "<OptionOnLinkedList>" link on the Linked List page
		And The user clicks "Try Here" button on "<OptionOnLinkedList>" page
		And The user clicks "Run" button after entering invalid code "<code>" in try editor 
		Then The user should see alert with error message "<message>" on TryEditor 

		Examples:
		| OptionOnLinkedList               | code             | message                                               |
		| Introduction                     | abc123           | NameError: name 'abc123' is not defined on line 1     |
		| Creating Linked LIst             | abc123           | NameError: name 'abc123' is not defined on line 1     |
		| Types of Linked List             | abc123           | NameError: name 'abc123' is not defined on line 1     | 
		| Implement Linked List in Python  | abc123           | NameError: name 'abc123' is not defined on line 1     |
		| Traversal                        | abc123           | NameError: name 'abc123' is not defined on line 1     |   
		| Insertion                        | abc123           | NameError: name 'abc123' is not defined on line 1     |   
		| Deletion                         | abc123           | NameError: name 'abc123' is not defined on line 1     |


