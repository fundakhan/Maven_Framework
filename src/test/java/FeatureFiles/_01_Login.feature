

@SmokeTest @Regression
Feature:  Login Functionality

  Scenario: Login with valid username and password

  Given Navigate to basqar
  When user enter username and password and click button
  Then user should login successfully
