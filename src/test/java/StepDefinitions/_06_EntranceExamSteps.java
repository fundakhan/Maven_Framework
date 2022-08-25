package StepDefinitions;

import Pages.DialogContent;
import Pages.FormContent;
import io.cucumber.java.en.When;

public class _06_EntranceExamSteps {

    DialogContent dialogContent = new DialogContent();
    @When("User delete the {string} from Form Content")
    public void userDeleteTheFromFormContent(String deleteExamName) {

       dialogContent.searchAndDelete(deleteExamName);


    }
}
