
Feature: product checkout

Scenario: Purchase Video Games with Specific Filters
    Given user Registered and logged in into demoblaze.com
    #And I log in
    When I open the left menu
    And I click on a category and choose a sub-category
    And I add a filter from the left side
    And I add another filter from the left side
    And I open the sort menu on the right side and sort by a specific option
    And I add all products with a cost below a certain amount to the cart
    #And I make sure all products are added to the cart
    #And I add my address and choose a payment method
    #Then I verify that the total amount, including shipping fees if applicable, is correct