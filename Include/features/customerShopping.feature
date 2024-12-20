Feature: Shopping functionality in General Store app

  Scenario: Add two products to the cart and validate total amount
    Given I open the General Store app on an Android device
    And I select "Egypt" country from the dropdown list
    And I enter my name as "Mohamed Ashraf" in the text field
    And I select my gender as "Male"
    When I click on the "Let’s Shop" button
    And I add "Product 1" to the cart
    And I add "Product 2" to the cart
    And I navigate to the cart screen
    Then I should see "Product 1" and "Product 2" displayed in the cart
    And I should see that the total amount equals the sum of "160.97" price and "120.0" price