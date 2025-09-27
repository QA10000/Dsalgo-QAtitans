Feature: Queue Page Functionality
  As a logged in user I should be able to access and use the Queue module

Background: 
    Given The user is on the DSAlgo portal
    When The user clicks "GetStarted" button on welcome page
    And The user logs in with valid username and password
    Then The user lands on the home page of DSAlgo portal
    
Scenario Outline: Verify the user is able to see all the headers/labels on the Queue Page
When The user clicks the "Getting Started" button for Queue module on Home page
Then The user should see the following "<Headers>" on the Queue Page 

         Examples:
         | Headers   		    |
         | Queue				|
         | Topics Covered		|
         

Scenario Outline: Verify the user is able to see all the headers/labels on the "Queue - Implementation of Queue in Python" Page
Given The user is on Queue page after login
When The user clicks on the "Implementation of Queue in Python" link on the Queue page
Then The user should see the following "<Navigating Links>" links on the "Queue - Implementation of Queue in Python" Page

         Examples:
 		 |Navigating Links 							|
         |NumpyNinja    							|
         |Data Structures  							|
         |Qatitans1   								|
         |Sign out     								|
         |Implementation of Queue in Python	  		|
         |Implementation using collections.deque	|
         |Implementation using array				|
         |Queue Operations							|
         
     
Scenario Outline: Verify the user is able to see all the headers/labels on the "Queue - Implementation using collections.deque" Page
Given The user is on Queue page after login
When The user clicks on the "Implementation using collections.deque" link on the Queue page
Then The user should see the following "<Navigating Links>" links on the "Queue - Implementation using collections.deque" Page

         Examples:
 		 |Navigating Links 							|
         |NumpyNinja    							|
         |Data Structures  							|
         |Qatitans1   								|
         |Sign out     								|
         |Implementation of Queue in Python	  		|
         |Implementation using collections.deque	|
         |Implementation using array				|
         |Queue Operations							|     
 
Scenario Outline: Verify the user is able to see all the headers/labels on the "Queue - Implementation using array" Page
Given The user is on Queue page after login
When The user clicks on the "Implementation using array" link on the Queue page
Then The user should see the following "<Navigating Links>" links on the "Queue - Implementation using array" Page

         Examples:
 		 |Navigating Links 							|
         |NumpyNinja    							|
         |Data Structures  							|
         |Qatitans1   								|
         |Sign out     								|
         |Implementation of Queue in Python	  		|
         |Implementation using collections.deque	|
         |Implementation using array				|
         |Queue Operations							|     
 
Scenario Outline: Verify the user is able to see all the headers/labels on the "Queue - Queue Operations" Page
Given The user is on Queue page after login
When The user clicks on the "Queue Operations" link on the Queue page
Then The user should see the following "<Navigating Links>" links on the "Queue - Queue Operations" Page

         Examples:
 		 |Navigating Links 							|
         |NumpyNinja    							|
         |Data Structures  							|
         |Qatitans1   								|
         |Sign out     								|
         |Implementation of Queue in Python	  		|
         |Implementation using collections.deque	|
         |Implementation using array				|
         |Queue Operations							|        

Scenario: Verify that user is able to navigate to "Queue - Implementation of Queue in Python" page	
When The user clicks the "Getting Started" button for Queue module on Home page
Then The user lands on "Queue" page

Scenario: Verify the user is able to navigate to "Queue" Data Structure page using dropdown on home page
Given The user is on the home page after login
When The user select Queue item from the drop down menu
Then The user lands on "Queue" page

Scenario: Verify the user is able to navigate to "Implementation of Queue in Python" page from "Queue" page
Given The user is on Queue page after login
When  The user clicks on the "Implementation of Queue in Python" link on the Queue page
Then The user lands on "Implementation of Queue in Python" page

Scenario: Verify the user is able to navigate to "Implementation using collections.deque" page from "Queue" page
Given The user is on Queue page after login
When  The user clicks on the "Implementation using collections.deque" link on the Queue page
Then The user lands on "Implementation using collections.deque" page

Scenario: Verify the user is able to navigate to "Implementation using array" page from "Queue" page
Given The user is on Queue page after login
When  The user clicks on the "Implementation using array" link on the Queue page
Then The user lands on "Implementation using array" page

Scenario: Verify the user is able to navigate to "Queue Operations" page from "Queue" page
Given The user is on Queue page after login
When  The user clicks on the "Queue Operations" link on the Queue page
Then The user lands on "Queue Operations" page

Scenario Outline: Verify the user sees the output on clicking "Run" button after entering valid code for "Implementation of Queue in Python" page
Given The user is on Queue page after login
When The user clicks on the "<OptionOnQueue>" link  
And The user clicks "Try Here" button on "<OptionOnQueue>" page
And The user clicks Run button after entering valid "<code>" in the try editor 
Then The user should see an output "<message>" on TryEditor

  	Examples:
	| OptionOnQueue		              			| code                            | message       				|
	| Implementation of Queue in Python     	| print('Hello World! QATitans1') | Hello World! QATitans1      |
	| Implementation using collections.deque    | print('Hello World! QATitans2') | Hello World! QATitans2   	|
	| Implementation using array       			| print('Hello World! QATitans3') | Hello World! QATitans3		| 
 	| Queue Operations 							| print('Hello World! QATitans4') | Hello World! QATitans4		|

Scenario Outline: Verify the user see an error message on clicking "Run" button after entering invalid code for "<OptionOnQueue>" page.  
Given The user is on Queue page after login
When The user clicks on the "<OptionOnQueue>" link on the Queue page
And The user clicks "Try Here" button on "<OptionOnQueue>" page
And The user clicks Run button after entering an invalid "<code>" in try editor 
Then The user should see an alert with error message "<message>" on TryEditor 

	Examples:
	| OptionOnQueue		              			| code    | message       										|
	| Implementation of Queue in Python     	| abc123  | NameError: name 'abc123' is not defined on line 1   |
	| Implementation using collections.deque    | abc123  | NameError: name 'abc123' is not defined on line 1   |
	| Implementation using array       			| abc123  | NameError: name 'abc123' is not defined on line 1   | 
 	| Queue Operations 							| abc123  | NameError: name 'abc123' is not defined on line 1   |
 	

