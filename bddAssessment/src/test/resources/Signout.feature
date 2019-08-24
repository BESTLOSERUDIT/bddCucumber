@Signout
Feature: Sign Off

Background: AltoroMutual Logo & Bussiness Links Validation
    Given I am on AttoroMutual Home Page
    And AtoroMutual Logo and Online Banking,Personal Banking,Small Business,INSIDE ALTORO MUTUAL link is displayed

Scenario Outline: Sign Off
Given I enter invalid "<username>" and "<password>"
When I click on login
And Online Banking Home page is displayed
When I click on Sign Off
Then User is logged out
Examples:

|username | password|
|jsmith   | Demo1234|