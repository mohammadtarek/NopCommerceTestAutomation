Feature: UserRegistration
I want to check that the user can register in our e-commerce website.

Scenario: User Registeration
Given the user in the home page
When I click on register link
And I entered the user "<firstname>","<lastname>","<email>","<password>"
Then The regiseration page displayed successfully

Examples: 
|firstname|lastname|email|password|
|ahmed|mohammad|Test@test.com|12345678|
|ahmed2|mohammad2|Test2@test.com|12345678|