package StepDefinitions;

import Pages.DialogContent;
import Utilities.DB_Utility;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class _11_JDBC_StatesSteps {
    @Then("Send the query the database {string} and control match")
    public void sendTheQueryTheDatabaseAndControlMatch(String query) {

        // DB den gerekli Listeyi alicam
        ArrayList<ArrayList<String>> dbList = DB_Utility.getListData(query); /** java nin var olan hali Polymorphism kullandik */
        System.out.println("dbList : " + dbList);  // 0. satirin 0. elemani id yani 1 olur. 1. elemani Alabama olur

        // Web den ekrandaki isimleri alicam  ve karsilastiricam
        DialogContent dialogContent = new DialogContent();
        List<WebElement> uiList = dialogContent.waitUntilVisibleAllElement(dialogContent.nameList);
        for (WebElement wb : uiList)
            System.out.println("wb.getText() : " + wb.getText());


        // karsilastiricam
        for (int i = 0; i < dbList.size(); i++) {
            Assert.assertEquals("Hatali durum" , dbList.get(i).get(1), uiList.get(i).getText());

        }


    }
}
