package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class _04_CitizenshipSteps {

    DialogContent dialogContent = new DialogContent();
    @And("Navigate to Citizenship page")
    public void navigateToCitizenshipPage() {
        LeftNav leftNav = new LeftNav();
        leftNav.findAndClick("setupOne");
        leftNav.findAndClick("parameters");
        leftNav.findAndClick("citizenship"); //find this locator
    }

    @When("User a Citizenship name as {string} short name as {string}")
    public void userACitizenshipNameAsShortNameAs(String name, String shortName) {
        dialogContent.findAndClick("addButton");
        dialogContent.findAndSend("nameInput",name);
        dialogContent.findAndSend("shortName",shortName); //find this locator
        dialogContent.findAndClick("saveButton");
    }

    @Then("Already exist message should be displayed")
    public void alreadyExistMessageShouldBeDisplayed() {
        dialogContent.findAndContainsText("alreadyExist", "already exist");
        // find this locator
    }

    @And("Click on close button")
    public void clickOnCloseButton() {
        dialogContent.findAndClick("closeDialog"); //find this locator
    }
}
