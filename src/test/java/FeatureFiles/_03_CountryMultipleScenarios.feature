
Feature: Country Multi Scenario

  Background:
    Given Navigate to basqar
    When user enter username and password and click button
    Then user should login successfully
    And Navigate to country page

  @Regression
  Scenario: Create a country

    When Create  a country
    Then Success message should be displayed

  @Regression
  Scenario: Create a country parameter data

      When Create a country name as "Turkey2" code as "code2"
      Then Success message should be displayed

