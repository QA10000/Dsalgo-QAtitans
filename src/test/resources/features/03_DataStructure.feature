Feature: DataStructure
	Background: 
    Given The user is on the DSAlgo portal
    When The user clicks "GetStarted" button on welcome page
    And The user logs in with valid username and password
    Then The user lands on the home page of DSAlgo portal

    Scenario: User is able to navigate to Data Structures introduction page
    When  The user clicks the Get Started button under Data Structures introduction panel
    Then  The user lands on Data Structures introduction page
    
    Scenario: User is able to navigate to Data Structures Time-Complexity page
    When The user clicks the Get Started button under Data Structures introduction panel
    Then The user lands on Data Structures introduction page
    When The user clicks the Time-Complexity link under Data Structures introduction panel
    
    Scenario: User is able to navigate to Data Structures Try Editor page and able to enter valid code 
    When The user clicks the Get Started button under Data Structures introduction panel
    Then The user lands on Data Structures introduction page
    When The user clicks the Time-Complexity link under Data Structures introduction panel
    Then The user lands on Time Complexity page
    When The user clicks the Try here>>> button at the bottom of the Time Complexity page
    Then The user lands on Try Editor page
    When The user enter valid python code in tryEditor "print \"Hello World\""
    Then The user should be presented with the run result
    
    Scenario: User is able to navigate to Data Structures Try Editor page
    When The user clicks the Get Started button under Data Structures introduction panel
    Then The user should be redirected to Data Structures introduction page
    When The user clicks the Time-Complexity link under Data Structures introduction panel
    Then The user lands on Time Complexity page
    When The user clicks the Try here>>> button at the bottom of the Time Complexity page
    Then The user lands on Try Editor page
    When The user enter invalid python code in tryEditor "Hello World"
    Then The user should be presented with the run result
    
	Scenario: Verify that "NumpyNinja" label is displayed on the top left corner of the Data Structure page
	Then The user sees "NumpyNinja" label on top-left corner of "Data Structure" page
	
	Scenario: Verify the data structures drop-down box is present on the top left corner of the Home page
	Then The user sees the "Data Structures" drop-down box on the top-left corner of the "Data Structure" page
	
	Scenario: Verify that link with "User Name" label is displayed on Data Structure page
	Then The user sees "Qatitans1" link on the top-right corner of Data Structure page
    
	Scenario: Verify that link with "Sign out" label is displayed on the Data Structure page
	Then The user sees "Sign out" link on the top-right corner of the Data Structure page
    