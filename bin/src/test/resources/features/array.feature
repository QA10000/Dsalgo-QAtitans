Feature:Array Functionality

  Background : 
    Given The user is on the DSAlgo portal
    When The user clicks "GetStarted button on welcome page
    Then The user lands on the home page of DSAlgo portal

  Scenario Outline: Verify that "NumpyNinja" label is displayed on the top left corner of the Register page
    Then The user see s"NumpyNinja" label on the top left corner of the "Register" page

  Scenario Outline: Verify the data structures select box is present on the top left corner of the register page
    Then The user sees the data structures select box on the top left corner of the "Register" page

  Scenario Outline: Verify that link with "Register" label is displayed on the Register page
    Then The user sees "Register" link on  the top right corner of the  Register page

  Scenario Outline: Verify that link with "Signin" label is displayed on the Register page
    Then The user sees "Signin" link on  the top right corner of the Register page

  Scenario Outline: Verify the Array Page shows 'Register' link
    Then The user can see Register link on the Array Page

  Scenario Outline: Verify that user is able to land on Array Page
    Then The User land on Array Page

  Scenario Outline: Verify that user receives error message for all empty fields during Array
    Given The user is on the DS Algo Sign in Page
    When The user clicks Array button Without entering any text in  "Username" textbox
    Then An error message "Please fill out this field." appears below Username textbox
