Feature: Checkout page
  Background: User is in the checkout page
    Given I am in sauce demo web page
    When I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button
    Then The home page should be displayed
    When I add the product "Sauce Labs Backpack" to the cart
    And I click on the cart button
    Then I click on the checkout button


  @run
  Scenario: Proceed to checkout without first name
    When I fill in the checkout fields with last name "de la Jaille" and postal code "3333"
    And I click on the continue button
    Then I should see an error message for missing first name
