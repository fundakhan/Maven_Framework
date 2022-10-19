package StepDefinitions;

import Pages.DialogContent;
import Utilities.ExcelUtility;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

public class _10_ApachePOI_CitizenSteps {

    DialogContent dialogContent = new DialogContent();

    @When("User Create citizenship with ApachePOI")
    public void userCreateCitizenshipWithApachePOI() {
        //excel den oku ve citizenship i create et
        ArrayList<ArrayList<String>> tablo=
                ExcelUtility.getListData("src/test/java/ApachePOI/Resource/ApacheExcel2.xlsx", "Page1",2); //excelUtility den aynisini aldik
        for (ArrayList<String> satir : tablo){
            dialogContent.findAndClick("addButton");
            dialogContent.findAndSend("nameInput",satir.get(0));
            dialogContent.findAndSend("shortName",satir.get(1));
            dialogContent.findAndClick("saveButton");
            dialogContent.findAndContainsText("successMessage","success");
        }

    }
    @Then("User Delete citizenship with ApachePOI")
    public void userDeleteCitizenshipWithApachePOI() {
        // kaydettiklerini yine excelden okuyarak sil
        ArrayList<ArrayList<String>> tablo=
                ExcelUtility.getListData("src/test/java/ApachePOI/Resource/ApacheExcel2.xlsx", "Page1",1);
        for (ArrayList<String> satir : tablo){
            dialogContent.searchAndDelete(satir.get(0));
            dialogContent.findAndContainsText("successMessage","success");
        }
    }


}
