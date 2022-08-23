Feature: Country Functionality

  Scenario: Create Country

    Given Navigate to basqar
    When user enter username and password and click button
    Then user should login successfully
    And Navigate to country page
    When Create  a country
    Then Success message should be displayed

