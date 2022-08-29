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

        dialogContent.findAndSend("username","richfield.edu");
        dialogContent.findAndSend("password", "Richfield2020!");

        dialogContent.findAndClick("loginButton");

    }

    @Then("user should login successfully")
    public void user_should_login_successfully(){

        dialogContent.findAndContainsText("dashboard", "Dashboard");
        dialogContent.findAndClick("acceptCookies");

    }
}
