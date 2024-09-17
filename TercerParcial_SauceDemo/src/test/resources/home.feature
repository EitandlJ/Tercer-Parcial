Feature: Home page
  Background: User login into Sauce Demo
    Given I am in sauce demo web page
    When I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button

  @run
  Scenario: Sort products from Z to A
    Given I am in sauce demo web page
    When I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button
    And I click on the filter button
    And I select the option to sort from Z to A
    Then The product "Test.allTheThings() T-Shirt (Red)" should be displayed in the home page

  @run
  Scenario Outline: Verify that products are displayed
    When The home page should be displayed
    Then The product "<products>" should be displayed in the home page
    Examples:
      | products                |
      | Sauce Labs Backpack     |
      | Sauce Labs Bike Light   |
      | Sauce Labs Bolt T-Shirt |
