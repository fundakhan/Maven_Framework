Feature: Testing JDBC States

  Background:
    Given Navigate to basqar
    When user enter username and password and click button
    Then user should login successfully

  Scenario: States testing with JDBC
    And Click on the element in the left Nav
      | setupOne   |
      | parameters |
      | states     |
    Then Send the query the database "select * from States" and control match




