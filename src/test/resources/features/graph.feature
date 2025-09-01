Feature: Validate Graph Module

Background: The user sign in to dsAlgo Portal

@Graph1
Scenario: Verify that user is able to navigate to "Graph" data structure page
Given The user is on the Home page after Sign in
When The user clicks the "Getting Started" button in Graph Panel 
Then The user be directed to "Graph" Data Structure Page

@Graph2
Scenario: Verify that user is able to navigate to "Graph" data structure page
Given The user is on the Home page after Sign in
When The user select Graph item from the drop down
Then The user be directed to "Graph" Data Structure Page

@Graph3
Scenario: Verify that user is able to navigate to "Graphs" page
Given The user is in the Assessments Page
When The user clicks the Case Details button
Then The user should be redirected to "Graphs" page

@Graph4
Scenario: Verify that user is able to navigate to "try here>>>" page for "Graph" page
Given The user is on the "Graphs" page
When The user clicks "Try Here>>>" button in Graphs in Python page
Then The user should be redirected to a page having an Editor with a "Run" button

@Graph5
Scenario: Verify that user receives error when click on "Run" button without entering code for "Graph" page
Given The user is in the tryEditor page
When The user clicks the "Run" button without entering the code in the Editor
Then The user should able to see an error message in alert window

@Graph6
Scenario: Verify that user receives error for invalid python code for "Graph" page
Given The user is in the tryEditor page
When The user write the invalid code in Editor and click the "Run" Button
Then The user should able to see an error message in alert window

@Graph7
Scenario: Verify that user is able to see output for valid python code for "Graph" page
Given The user is in the tryEditor page
When The user write the valid code in Editor and click the "Run" Button
Then The user should able to see output in the console with no error message

@Graph8
Scenario: Verify that user is able to navigate to "Practice Questions" Page for "Graph" page
Given The user is in the "Graph" page after Sign in
When The user clicks "Practice Questions" link in the left navigation bar
Then The user should be redirected to "Practice Questions" page

@Graph9
Scenario: Verify that user is able to navigate to "Graph Representations" page from "Graph" page
Given The user is on the "Graph" page
When The user clicks the "Graph Representation" link in the left navigation bar
Then The user should be redirected to "Graph Represntations" page, and try Editor with "Run" button

@Graph10
Scenario: Verify that user receives error for invalid python code on running "Graph Representations" page
Given The user is on the practice question editor
When The user writes the invalid code in Editor and Click the Run Button
Then The user should able to see an error message in alert window

@Graph11
Scenario: Verify that user is able to run valid python code for "Graph Representations" page
Given The user is on the practice question editor
When The user write the valid code in Editor and Click the Run Button
Then The user should able to see output in the console

@Graph12
Scenario: Verify that user receives error on submitting invalid python code for "Graph Representations" page
Given The user is on the practice question editor
When The user write the invalid code in Editor and Click the "Run" Button
Then The user see an error message "Error occurred during submission"

@Graph13
Scenario: Verify that user receives error on submitting invalid python code for "Graph Representations" page
Given The user is on the practice question editor
When The user write the invalid code in Editor and Clicks "Run" Button
Then The user see output with no error message



