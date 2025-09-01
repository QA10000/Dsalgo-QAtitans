Feature:LinkedList Functionality

   Background: 
    Given The user is on the DSAlgo portal
    When The user clicks "GetStarted" button on welcome page
    Then The user lands on the home page of DSAlgo portal
  
#Scenario: Verify that user is able to navigate to Login page
#	Given The user is on the home page of the portal
#	When The user clicks on the Signin link on home page
#	Then The user lands on Login page

#Scenario: Verify the user is landing on the DsAlgo home portal after entering valid username and password
#    Given The user is on the home page of the portal
 #   When The user clicks login button after entering valid values from "Sheet1"
  #  Then The user lands on the DS Algo Home portal with success message "You are logged in"
 
 Scenario: Verify that user is able to navigate to "Linked List - Introduction" page	
 	Given The user is on the home page after login	
 	When The user clicks the "Getting Started" button for Linked List module on Home page
 	Then The user lands on the "Linked List" page
 	
 Scenario: Verify the user is able to navigate to "Linked List" Data Structure page using dropdown on home page
 Given The user is on the home page after login
 When The user select Linked List  item from the drop down menu
 Then The user lands on the "Linked List" page

Scenario: Verify the user is able to navigate to "Creating Linked List" page from "Linked List" page
Given The user is on the Linked List page 
When The user clicks on the "Creating Linked List" link on  the Linked List page
Then The user lands on the "Creating Linked LIst" page

 #Scenario : Verify the user see a error message on clicking "Run" button after entering wrong code
 Given The user is on "TryEditor" page
 When The user is on "TryEditor" page
 Then The user should see error message stating that user should enter valid python code