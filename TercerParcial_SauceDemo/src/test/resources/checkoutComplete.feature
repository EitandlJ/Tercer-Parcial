Feature: Checkout Complete page
  Background: User is in the checkout page
    Given I am in sauce demo web page
    When I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button
    Then The home page should be displayed
    And I click on the cart button
    Then I click on the checkout button

  @run
  Scenario: Complete the shopping without products
    When I fill in the checkout fields with first name "Eitan" last name "de la Jaille" and postal code "3333"
    And I click on the continue button
    And I click on the finish button
