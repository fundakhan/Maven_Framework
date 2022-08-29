package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;

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
        String randomGenName = RandomStringUtils.randomAlphabetic(8); // excel repository ekledikten sonra bu ikisini ekledik
        String randomGenCode = RandomStringUtils.randomNumeric(4);
        dialogContent.findAndClick("addButton");
        dialogContent.findAndSend("nameInput",randomGenName);
        dialogContent.findAndSend("codeInput",randomGenCode);
        dialogContent.findAndClick("saveButton");

    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {

        dialogContent.findAndContainsText("successMessage", "success");
    }

    @When("Create a country name as {string} code as {string}")
    public void createACountryNameAsCodeAs(String name, String code) {
        dialogContent.findAndClick("addButton");
        dialogContent.findAndSend("nameInput",name);
        dialogContent.findAndSend("codeInput",code);
        dialogContent.findAndClick("saveButton");
    }
}
