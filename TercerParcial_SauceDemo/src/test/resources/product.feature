Feature: Product page
  Background: User login into Sauce Demo
    Given I am in sauce demo web page
    When I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button

  @run
  Scenario: Review the Bolt page
    When I click on the Bolt Product
    Then The Bolt product page should be displayed
