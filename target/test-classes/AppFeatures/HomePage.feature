Feature: Home Page Test

	Background:
		Given User enters the url "https://www.lenskart.com/" in the browser
		And User sign in with valid username "automationpractice20@gmail.com" and password "NewAutomationpractice20@gmail.com"

  Scenario: Login panel item count
    When User gets the count of login panel items
    Then Login panel item count should be "5"
    And Login panel items should be
      | My Orders |
      | My Prescription  |
      | My Store Credit |
      | Account Information |
      | Logout |
    