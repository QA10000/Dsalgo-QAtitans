Feature: DataStructure
	
	Scenario: User is Logged into DS-Algo page
    Given The user is on signon page of the DS-Algo page
    When 	The user enter valid username "roopzsohani@gmail.com" and password "roopaaradhy1049*"
    Then  It should display "You are logged in"
    
    Scenario: User is able to navigate to Data Structures introduction page
    Given The user is on the home page after successful login with username "roopzsohani@gmail.com" and password "roopaaradhy1049*" with message "You are logged in"
    When  The user clicks the Get Started button under Data Structures introduction panel
    Then  The user should be redirected to Data Structures introduction page