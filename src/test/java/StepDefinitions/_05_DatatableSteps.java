package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

import java.util.List;

public class _05_DatatableSteps {

    LeftNav leftNav = new LeftNav();
    DialogContent dialogContent = new DialogContent();
    @And("Click on the element in the left Nav")
    public void clickOnTheElementInTheLeftNav(DataTable elements) { 

        List<String> listElement = elements.asList(String.class); 

        for (int i = 0; i < listElement.size(); i++) {
          //  System.out.println("listElement : " + listElement.get(i));
            leftNav.findAndClick(listElement.get(i));

        }
    }

    @And("Click on the element in the Dialog")
    public void clickOnTheElementInTheDialog(DataTable elements) {

        List<String> listElement = elements.asList(String.class);

        for (int i = 0; i < listElement.size(); i++) {
           // System.out.println("listElement : " + listElement.get(i));
            dialogContent.findAndClick(listElement.get(i));

        }
    }

    @And("User sending the keys in Dialog Content")
    public void userSendingTheKeysInDialogContent(DataTable elements) {

       
        List<List<String>> listElement = elements.asLists(String.class);

        for (int i = 0; i < listElement.size(); i++) {
            dialogContent.findAndSend(listElement.get(i).get(0), listElement.get(i).get(1));
         
        }

    }

    @And("User delete item from Dialog")
    public void userDeleteItemFromDialog(DataTable elements) {
        List<String> listElement = elements.asList(String.class);
        for (int i = 0; i < listElement.size(); i++) {
            dialogContent.searchAndDelete(listElement.get(i));
        }


    }
}
