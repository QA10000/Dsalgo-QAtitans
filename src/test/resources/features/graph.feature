Feature: Graph Page Functionality
  As a logged in user I should be able to access and use the Graph module

#PASSED
Background: 
    Given The user is on the DSAlgo portal
    When The user clicks "GetStarted" button on welcome page
    And The user logs in with valid username and password 
    
    Then The user lands on the home page of DSAlgo portal

#PASSED
#STEP1 - Main Graph Page Headers
Scenario Outline: Verify the user is able to see all the headers/labels on the Graph Page
When The user clicks the "Getting Started" button for the Graph module on Home page
Then The user should see the following "<Headers>" on the Graph Page 

         Examples:
         | Headers       |
         | Graph		 |
         | Topics Covered|
         
#PASSED
#STEP2 - Main Graph Page headers with links
Scenario Outline: Verify the user is able to see all the headers/labels on the Graph Page
When The user clicks the "Getting Started" button for Graph module on Home page
Then The user should see the following "<Navigating Links>" links on the "Graph" Page 

         Examples:
         |Navigating Links	 	|
         |NumpyNinja     		|
         |Data Structures   	|
         |Qatitans1      		|
         |Sign out     			|
         |Graph     			|
         |Graph Representations	|
 
 #PASSED       
 #STEP3 - Main Graph Page >> 1. Graph Page headers with links
 Scenario Outline: Verify the user is able to see all the headers/labels on the "Graph - Graph" Page
 Given The user is on Graph page after login
 When The user clicks now on the "Graph" link on the Graph page
 Then The user should see the following "<Navigating Links>" links on the "Graph - Graph" Page
         Examples:
         |Navigating Links		 |
         |NumpyNinja     		 |
         |Data Structures 		 |
         |Qatitans1      		 |
         |Sign out       		 |
         |Graph			 		 |
         |Graph Representations  |
         |Practice Questions	 |
         |Try here>>>			 |
  
#PASSED               
#STEP4 - Main Graph Page >> 2. Graph Representations Page headers with links
 Scenario Outline: Verify the user is able to see all the headers/labels on the "Graph - Graph Representations" Page
 Given The user is on Graph page after login
 When The user clicks now on the "Graph Representations" link on the Graph page
 Then The user should see the following "<Navigating Links>" links on the "Graph - Graph Representations" Page
         Examples:
         |Navigating Links		 |
         |NumpyNinja     		 |
         |Data Structures 		 |
         |Qatitans1      		 |
         |Sign out       		 |
         |Graph			 		 |
         |Graph Representations  |
         |Practice Questions	 |
         |Try here>>>			 |

#PASSED
#STEP5 - From Home Page, go to Graph page by clicking Get Started - new
Scenario: Verify that user is able to navigate to "Graph" page	
 #	Given The user is on the home page after login	
 	When The user clicks the "Getting Started" button for Graph module on Home page
 	Then The user lands on "Graph" page
 	
#PASSED
#STEP6 - From Home Page, go to Graph page by selecting Graph from dropdown menu
Scenario: Verify the user is able to navigate to "Graph" Data Structure page using dropdown on home page
 Given The user is on the home page after login success
 When The user select Graph item from the drop down menu
 Then The user lands on "Graph" page

#PASSED
#STEP7 - From Graph Page, going to 1.Graph page
Scenario: Verify the user is able to navigate to "Graph" page from "Graph" page
Given The user is on Graph page after login
When  The user clicks now on the "Graph" link on the Graph page
Then The user lands on "Graph" page

#PASSED
#STEP8 - From Graph Page, going to 2.Graph Representations
Scenario: Verify the user is able to navigate to "Graph Representations" page from "Graph" page
Given The user is on Graph page after login
When  The user clicked now on the "Graph Representations" link on the Graph page
Then The user lands on "Graph Representations" page

#PASSED
#STEP9- In 2.Graph Representations Page, try valid code     
  Scenario Outline: Verify that user is able to see output for valid python code for "<OptionOnGraph>" page
    Given The user is on Graph page after login
    When The user clicks on the "<OptionOnGraph>" link on the Graph page
    And The user clicks "Try Here" button on "<OptionOnGraph>" page
    And The user clicks Run button here after entering an valid "<code>" in try editor
    Then The user should able to see "<message>" output in the console on the try editor
    #When The user selects "<OptionOnGraph>" link on Graph page
    #And Now the user clicks "Try Here" button on the "<OptionOnGraph>" page
    #And run valid code by clicking run button after entering "<code>" in try editor for graph module
    #Then The user should able to see "<message>" output in the console on Graph Module in the code page

    Examples: 
      | OptionOnGraph		   	  | code                     | message         |
      | Graph			          | print('Hello QATitans!') | Hello QATitans! |
      | Graph Representations     | print('Hello QATitans!') | Hello QATitans! |
      
#PASSED
#STEP10 - Old- In 2.Graph Representations Page, try invalid code
Scenario Outline: Verify the user see an error message on clicking "Run" button after entering invalid code for "<OptionOnGraph>" page.  
    Given The user is on Graph page after login
    When The user clicks on the "<OptionOnGraph>" link on the Graph page
    And The user clicks "Try Here" button on "<OptionOnGraph>" page
    And The user clicks Run button here after entering an invalid "<code>" in try editor 
    Then The user should see an alert with error message "<message>" on the try editor

    Examples: 
      | OptionOnGraph           | code | message                                    |
      | Graph				    | abcd | NameError: name 'abcd' is not defined on line 1 |
      | Graph Representations	| abcd | NameError: name 'abcd' is not defined on line 1 |
      
 