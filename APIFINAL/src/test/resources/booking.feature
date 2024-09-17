Feature: Booking endpoint
  Background: Booking endpoints should allow to get and create Bookings

  Scenario: Verify GET booking with invalid id
    Given I perform a GET call to the booking endpoint with id "30000"
    And I verify that the status code is 404
    And The message is "Not Found"

  Scenario: Verify GET booking by id
    Given I perform a GET call to the booking endpoint with id "10"
    Then I verify that the status code is 200
    And The booking details are as follows:
      | firstname   | Mark       |
      | lastname    | Ericsson   |
      | totalprice  | 741        |
      | depositpaid | false      |
      | checkin     | 2024-04-14 |
      | checkout    | 2024-06-22  |


  Scenario: Create a new booking POST
    Given I perform a POST call to the booking endpoint with the following data:
      | firstname       | Julio      |
      | lastname        | Cabezas    |
      | totalprice      | 1000       |
      | depositpaid     | true       |
      | checkin         | 2001-12-18 |
      | checkout        | 2019-04-08 |
      | additionalneeds | Breakfast  |
    Then I verify that the status code is 200



  Scenario: Create a new booking with missing fields POST
    Given I perform a POST call to the booking endpoint with the following incomplete data:
      | firstname       | Juan       |
      | lastname        |            |
      | totalprice      | 800        |
      | depositpaid     | false      |
      | checkin         | 2018-03-09 |
      | checkout        | 2019-04-08 |
      | additionalneeds | Breakfast  |
    Then I verify that the status code is 400
    And The message is "Bad Request"

  Scenario: Create a new booking with invalid fields POST
    Given I perform a POST call to the booking endpoint with the following invalid data:
      | firstname       | 69071          |
      | lastname        | !@             |
      | totalprice      | one hundred    |
      | depositpaid     | null           |
      | checkin         | random_date    |
      | checkout        | null_date      |
      | additionalneeds | InvalidRequest |
    Then I verify that the status code is 400
    And The message is "Bad Request"