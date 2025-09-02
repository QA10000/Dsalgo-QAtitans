
Feature: Tree Page Functionality
  As a logged in user I should be able to access and use the Tree module

  Background:
    Given The user is on the DSAlgo portal
     When The user clicks "GetStarted button on welcome page"
     Then The user lands on the home page of DSAlgo portal
     And The user logs in with valid credentials
   
  Scenario: User navigates to the "Tree" Data Structure page from the home page
    When The user clicks the "Getting Started" button for Tree on the Home page
    Then The user lands on the "Tree Data Structure" page

  Scenario: User navigates to the "Tree" Data Structure page using the dropdown
   When The user selects "Tree" item from the dropdown menu
    Then The user lands on the "Tree" Data Structure page

  Scenario: User navigates to "Overview of Tree" page
   # Given The user is able to sign into the DSAlgo portal
    And The user is on the "Tree" Data Structure page
    When The user clicks on "Overview of Trees" link on the Tree page
    Then The user lands on the "Overview of Trees" page

  Scenario: User navigates to "tryEditor" page for "Overview of Tree"
   # Given The user is able to sign into the DSAlgo portal
    And The user is on "Overview of Tree" page
    When The user clicks on "Try here" button on "Overview of Tree page"
    Then The user is on "tryEditor" page

  Scenario: User sees an error message when clicking "Run" without entering code
   # Given The user is able to sign into the DSAlgo portal
    And The user is on "TryEditor" page
    When The user clicks on "Run" button without entering any python code
    Then The user should see an error message stating that the user should enter valid python code

  Scenario: User sees an error message when clicking "Run" after entering wrong code
   # Given The user is able to sign into the DSAlgo portal
    And The user is on "TryEditor" page
    When The user clicks on "Run" button after entering wrong python code
    Then The user should see an error message stating that the user should enter valid python code

  Scenario: User sees correct output when clicking "Run" after entering correct code
   # Given The user is able to sign into the DSAlgo portal
    And The user is on "TryEditor" page
    When The user clicks on "Run" button after entering correct python code
    Then The user should see the correct output

  Scenario: Verify that "NumpyNinja" label is displayed on the Tree page
  #  Given The user is on the DSAlgo Tree page
    When The user is on the "Tree" page
    Then The user sees "NumpyNinja" label on the "Tree" page

  Scenario: Verify that "Sign out" button is displayed on the Tree page
   # Given The user is on the DSAlgo Tree page
    When The user is on the "Tree" page
    Then The user sees a button with "Sign out" label on the "Tree" page

  Scenario: Verify that "Data Structures" dropdown is visible on the Tree page
   # Given The user is on the DSAlgo Tree page of the portal
    When The user is on the "Tree" page
    Then The user sees "Data Structure" dropdown

  Scenario: Verify that "Topics Covered" label is displayed on the "Tree" page
   # Given The user is on the DSAlgo Tree page
    When The user is on the "Tree" page
    Then The user sees "Topics Covered" label on the "Tree" page

  Scenario: Verify that "Tree" label is displayed on the "Tree" page
   # Given The user is on the DSAlgo Tree page
    When The user is on the "Tree" page
    Then The user sees "Tree" label on the "Tree" page