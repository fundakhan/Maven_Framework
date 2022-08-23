Feature: Citizenship with scenario Outline

  Background:
    Given Navigate to basqar
    When user enter username and password and click button
    Then user should login successfully
    And Navigate to Citizenship page

    Scenario Outline: Citizenship create
      When User a Citizenship name as "<CitizenshipName>" short name as "<ShortName>"
      Then Success message should be displayed

      When User a Citizenship name as "<CitizenshipName>" short name as "<ShortName>"
      Then Already exist message should be displayed
      And Click on close button


      Examples:
        | CitizenshipName | ShortName |
        | American6       | usa1      |
        | American7       | usa2      |
        | American8       | usa3      |
        | American9       | usa4      |
        | American10       | usa5      |