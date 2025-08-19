Feature: User Registration
  
  As a new user
  I want to register with a username and password
  So that I can log in to the DSALgo portal

  Background: 
    Given The user is on the DSAlgo portal
    When The user clicks "GetStarted button on welcome page"
    Then The user lands on the home page of DSAlgo portal

   Scenario: Verify that user is able to navigate to Register page
    Given The user is on the home page of the portal
    When The user clicks on the Register link on home page
    Then The user lands on Register page
    # Scenario: Verify that "NumpyNinja" label is displayed on the top left corner of the Register page
    #  Then The user sees "NumpyNinja" label on the top left corner of the "Register" page
    #Scenario: Verify the data structures select box is present on the top left corner of the register page
    #  Then The user sees the data structures select box on the top left corner of the "Register" page
    #Scenario: Verify that link with "Register" label is displayed on the Register page
    #  Then The user sees "Register" link on  the top right corner of the  Register page
    #Scenario: Verify that link with "Signin" label is displayed on the Register page
    # Then The user sees "Signin" link on the top right corner of the Register page
    #Scenario: Verify the Username label is present in the Register page
    #  Then The user sees "username" label on Regiser pagepage
    #Scenario: Verify the Username label is present in the Register page
    #  Then The user sees "password" label on Regiser pagepage
    #Scenario: Verify the Password Confirmation label is present in the Register page
    #  Then The user sees "confirm password" label on Register page
    # Scenario: Verify the Register button is present in the Register page
    # Then The user sees "Register Button" label on Register page
    #Scenario: Verify the Register button is present in the Register page
    #  Then The user sees "Register Button" label on Register page
    # Scenario: Verify the Login link is present in the register page
    # Then The user sees "Login Link" on the Register page

  # Scenario: Verify that the user receives proper error message for empty username
  #  Given The user is on the register page of the portal
  #  When The user clicks 'Register' button without entering username
  #  Then The error message 'Please fill out this field' should be displayed
  
  # Scenario: Verify that the user receives proper error message for empty password
  #  Given The user is on the register page of the portal
  # When The user clicks 'Register' button without entering username
  # Then The error message 'Please fill out this field' should be displayed
  
  #Scenario: Verify the user receives proper error message when entering numeric values only in username
  # Given The user is on the register page of the portal
  # When The user clicks Register button after entering "777777" values in username text box and valid password
  # Then The error message 'Username should not be numeric' should be displayed
  
  # Scenario: Verify that the user receives proper error message when entering numeric values in password field
  #  Given The user is on the register page of the portal
  #  When The user clicks Register button after entering "777777" values in password text box and valid username
  #Then The error message 'Password should not be numeric' should be displayed
  #Scenario: Verify the user receives proper error message when entering special characters  in password
  #Given The user is on the register page of the portal
  #When The user clicks Register button after entering "@#$%$$" values in passwordtext box and valid username
  #Then The error message 'Password should not be numeric' should be displayed
  #Scenario: Verify that user receives error message for invalid username field during registration
  #Given The user is on the register page of the portal
  #When The user clicks Register button after entering a username with spacebar characters other than digits and @/./+/-/_
  #Then The user should see an error message reading "password_mismatch:The two password fields didn’t match."
  #Scenario: Verify that user receives error message for invalid username field during registration
  # Given The user is on the register page of the portal
  # And The user clicks Register button after entering a username with spacebar characters other than digits and @/./+/-/_
  # Then The user should see an error message reading "password_mismatch:The two password fields didn’t match."
  #Scenario: Verify that user receives error message for invalid username field during registration
  #Given The user is on the register page of the portal
  # When The user clicks Register button after entering a username with spacebar characters other than digits and @/./+/-/_
  # Then The user should see an error message reading "password_mismatch:The two password fields didn’t match."
  Scenario: Verify the user receives proper error message when giving different password and password confirmation
    Given The user is on the register page of the portal
    When The user submits the registration form with mismatched passwords:
      | username   | password  | confirmpassword |
      | TestUser01 | Test@1234 | Test@12346      |
      | TestUser02 | Test@1234 | Test@12347      |
      | TestUser03 | Test@1234 | Test@12348      |
      | TestUser04 | Test@1234 | Test@12349      |
    Then The user sees "password_mismatch:The two password fields didn’t match." error message

  #Scenario: Verify the user receives proper error message when entering already exists username
  # Given The user is on the register page of the portal
  # When The user clicks Register button after entering "1@Chicago" values in password text box and valid username and "1@test" value in confirm password text box
  # Then The user sees "If you already have an account, please Login instead!" message on the Register page
  #Scenario: Verify that user sees error message using common information for username and password
  # Given The user is on the register page of the portal
  # When The user enters admin in username text box and password in password textbox
  # Then The user should see a message suggesting to enter a strong username and password
  Scenario Outline: Verify the user is landing on the DsAlgo home portal after entering valid username and password
    Given The user is on the register page of the portal
    #When The user enters "<username>", "<password>", "<confirmedpassword>" and clicks the Register button
    When The user clicks Register button after entering valid values from "<Sheet>"
    Then The user lands on the DSAlgo Home portal with Success Message "New Account Created. You are logged in as <username>"

    Examples: 
      | Sheet  |
      | Sheet1 |