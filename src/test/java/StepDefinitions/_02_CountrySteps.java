package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class _02_CountrySteps {
    LeftNav leftNav = new LeftNav();
    DialogContent dialogContent = new DialogContent();
    @And("Navigate to country page")
    public void navigateToCountryPage() {
        leftNav.findAndClick("setupOne"); // setup click
        leftNav.findAndClick("parameters"); // parameters click
        leftNav.findAndClick("countries"); // countries click

    }

    @When("Create  a country")
    public void createACountry() {
        dialogContent.findAndClick("addButton");
        dialogContent.findAndSend("nameInput","America8");
        dialogContent.findAndSend("codeInput","1111");
        dialogContent.findAndClick("saveButton");

    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        dialogContent.findAndContainsText("successMessage", "successfully");
    }
}
