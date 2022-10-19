Feature: ApachePOI Citizenship Functionality

  Background:
    Given Navigate to basqar
    When user enter username and password and click button
    Then user should login successfully
    And Navigate to Citizenship page

    Scenario: Create and delete citizenship from Excel
      When User Create citizenship with ApachePOI
      Then User Delete citizenship with ApachePOI