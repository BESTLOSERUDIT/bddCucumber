@login
Feature: Login

Background: AltoroMutual Logo & Bussiness Links Validation
    Given I am on AttoroMutual Home Page
    And AtoroMutual Logo and Online Banking,Personal Banking,Small Business,INSIDE ALTORO MUTUAL link is displayed

Scenario Outline: Invalid Login
When I enter invalid "<username>" and "<password>"
And I click on login
Then the error message is displayed
Examples:

|username | Password|
|uditt     | 1234    |


Scenario Outline: Valid Login
When I enter valid "<userName>" and "<passWord>"
And I click on login
Then Online Banking Home page is displayed

Examples:

|userName | passWord|
|jsmitht   |Demo1234 |

