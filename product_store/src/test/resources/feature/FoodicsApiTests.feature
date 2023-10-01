Feature: Testing Foodics API

  Background:
    Given the base URL is "https://pay2.foodics.dev"
    And the email is "merchant@foodics.com"
    And the password is "123456"
    And the token is "Lyz22cfYKMetFhKQybx5HAmVimF1i0xO"

  Scenario: Verify Successful Login
    When I make a POST request to "/login"
    Then the response status code should be 200

  Scenario: Verify WhoAmI Endpoint with Valid Token
    When I make a GET request to "/whoami"
    Then the response status code should be 200

  Scenario:Verify failed Logout
    Given the token is "Lyz22cfYKMetFhKQybx5HAmVimF1i0xO"
    When I make a GET req to "/Logout"
    Then the response status code should be 302
