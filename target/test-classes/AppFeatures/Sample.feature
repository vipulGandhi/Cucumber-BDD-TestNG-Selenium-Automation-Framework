#Tag applied at the feature level by default gets applied to all scenarios


@All
Feature: Login


	@Smoke, @Regression, @UserStory-1001, @Epic-2001
  Scenario Outline: Login with valid usernme and password
    Given User is at the login page
    When User enter valid username "<username>" and password <password>
    Then Webpage redirects to user dashboard

    Examples: 
      | username   | password |
      | username_A | 123456   |
      | username_B | 123456   |
      | username_C | 123456   |
      | username_D | 123456   |
     	| username_E | 123456   |