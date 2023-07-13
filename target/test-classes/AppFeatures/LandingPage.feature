Feature: Landing page feature

Scenario: Landing page title
Given User enters the url "https://www.lenskart.com/" in the browser
Then Page title should contain "Lenskart.com"

Scenario: Landing page url
Given User enters the url "https://www.lenskart.com/" in the browser
Then Page url should contain "lenskart.com"

Scenario: Login with correct credentials
Given User enters the url "https://www.lenskart.com/" in the browser
When User sign in with valid UserName and Password
		| UserName | Password |
		| automationpractice20@gmail.com | NewAutomationpractice20@gmail.com |
Then User is on the dashboard with the username "Vipul"
