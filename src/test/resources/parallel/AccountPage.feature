Feature: Account page feature

Background:
Given User should be logged in to application
|Username|Password|
|hemsundergoud@gmail.com|Hem@561kb|

Scenario: Search for a product
Given User has search feild to search for a product
When User enters productname in search feild
|MacBook Pro|
Then Product should be displayed

Scenario: My Account submenu links validation
Given User should find the My account sub menu options
Then User should find the below links
|Edit your account information|
|Change your password|
|Modify your address book entries|
|Modify your wish list|