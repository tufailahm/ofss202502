Feature: Login functionality

  Scenario Outline: Valid user login
    Given Customer is on the login page
    When User enters valid <username> and <password>
    Then User should be redirected to the dashboard
    Examples:
      | username | password |
      | standard_user | secret_sauce |
      | navya | secret_sauce |
      | hashmita | topsecret |
      | jahnav | password |


