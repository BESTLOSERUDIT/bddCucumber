@Transfer
Feature: Fund Transfer

Background: Online Banking Home Page validation
    Given I am on AttoroMutual Home Page
    And AtoroMutual Logo and Online Banking,Personal Banking,Small Business,INSIDE ALTORO MUTUAL link is displayed 


Scenario Outline: Transfer Funds
Given I enter valid "<userName>" and "<passWord>"
And I click on login
Given I am on Transfer Funds Page
When I select from account "<fromAcc>"
And I select to account "<toAcc>"
And I enter Amount to transfer "<transferAmt>"
And I click on Transfer Money
Then a message is displayed with correct amount and from/to account details

Examples:

|userName|passWord|fromAcc        |toAcc          |transferAmt|
|jsmith  |Demo1234|800002 Savings |800003 Checking|2019       |

