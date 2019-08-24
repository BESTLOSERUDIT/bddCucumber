@HomePage
Feature: Online Banking Home Page

Background: Online Banking Home Page validation
    Given I am on AttoroMutual Home Page
    And AtoroMutual Logo and Online Banking,Personal Banking,Small Business,INSIDE ALTORO MUTUAL link is displayed

Scenario Outline: Bank Account selection and Verification

Given I enter valid "<userName>" and "<passWord>"
And I click on login
Then Online Banking Home page is displayed
When I select Bank Account "<bankAcNo>"
And I click on Go button
Then Account Information page is displayed
And the account no "<bankAcNo>" is displayed in heading with Account History

Examples:
|userName |passWord | bankAcNo      |
|jsmith   |Demo1234 |800003 Checking|

#Scenario: Date Validation in Balance Detail section
#Given I am on Account Information page
#Then Ending Balance should be shown as per current date 

