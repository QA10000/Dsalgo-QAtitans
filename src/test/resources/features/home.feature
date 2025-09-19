Feature: Home Functionality

  Background: 
    Given The user is on the DSAlgo portal
    When The user clicks "GetStarted" button on welcome page
    Then The user lands on the home page of DSAlgo portal

	Scenario: Verify that user able to see error message on clicking "Get Started" button
	# Given The user is in the DS Algo Home Page
	When The User clicks GetStarted button of Data Structures-Introduction module on DS Algo Home page
	Then The user should able to see an warning message "You are not logged in"	

    Scenario: Verify that user able to see error message on clicking "Get Started" button
	# Given The user is in the DS Algo Home Page
	When The User clicks GetStarted button of Array module on DS Algo Home page
	Then The user should able to see an warning message "You are not logged in"

	Scenario: Verify that user able to see error message on clicking "Get Started" button
	# Given The user is in the DS Algo Home Page
	When The User clicks GetStarted button of Linked List module on DS Algo Home page
	Then The user should able to see an warning message "You are not logged in"
	
	Scenario: Verify that user able to see error message on clicking "Get Started" button
	# Given The user is in the DS Algo Home Page
	When The User clicks GetStarted button of Stack module on DS Algo Home page
	Then The user should able to see an warning message "You are not logged in"  
    
	Scenario: Verify that user able to see error message on clicking "Get Started" button
	# Given The user is in the DS Algo Home Page
	When The User clicks GetStarted button of Queue module on DS Algo Home page
	Then The user should able to see an warning message "You are not logged in"	
	
	Scenario: Verify that user able to see error message on clicking "Get Started" button
	# Given The user is in the DS Algo Home Page
	When The User clicks GetStarted button of Tree module on DS Algo Home page
	Then The user should able to see an warning message "You are not logged in"	

	Scenario: Verify that user able to see error message on clicking "Get Started" button
	# Given The user is in the DS Algo Home Page
	When The User clicks GetStarted button of Graph module on DS Algo Home page
	Then The user should able to see an warning message "You are not logged in"	