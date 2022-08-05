Feature: Login Feature

Scenario: Application title scenario
Given User is on Login page
Then Title of the login page should be "Account Login"

Scenario: Logo in Login page
Given User is on Login page
Then Logo should be displayed

@Skip
Scenario: User login
Given User is on Login page
When User enters "hemsundergoud@gmail.com" in username textbox
And User enters "Hem@561kb" in the password textbox
And User clicks on Login button
Then User should be able to login and landed in Accounts page

	
	