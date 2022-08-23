package StepDefinitions;

import Pages.DialogContent;
import Utilities.BaseDriver;
import io.cucumber.java.en.*; // tek tek import yerine * koyunca hepsini goruyor



public class _01_LoginSteps {

    DialogContent  dialogContent = new DialogContent();
    @Given("Navigate to basqar")
    public void navigate_to_basqar(){

        BaseDriver.getDriver().get("https://demo.mersys.io/");
        BaseDriver.getDriver().manage().window().maximize();

    }

    @When("user enter username and password and click button")
    public void enter_username_and_password_and_click_button(){


//        dialogContent.username.sendKeys("richfield.edu");
//        dialogContent.password.sendKeys("Richfield2020!");
//        dialogContent.loginButton.click();

/** 1. asama burada basliyor */
        dialogContent.findAndSend("username","richfield.edu");
        dialogContent.findAndSend("password", "Richfield2020!");

        dialogContent.findAndClick("loginButton");

    }

    @Then("user should login successfully")
    public void user_should_login_successfully(){

        // dialogContent.waitUntilVisible(dialogContent.dashboard);
        // Assert.assertTrue(dialogContent.dashboard.getText().contains("Dashboard"));

        dialogContent.findAndContainsText("dashboard", "Dashboard");

    }
}
