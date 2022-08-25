package Pages;

import Utilities.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormContent  extends Parent{

    public FormContent(){
        PageFactory.initElements(BaseDriver.getDriver(),this);
    }

    @FindBy(xpath = "(//mat-select[@formcontrolname='id']/div/div)[1]")
    private WebElement academicPeriod;

    @FindBy(xpath = "(//mat-option[@role='option']/span)[1]")
    private WebElement academicPeriod1;

    @FindBy(xpath = "(//mat-select[@formcontrolname='id']/div/div)[3]")
    private WebElement gradeLevel;

    @FindBy(xpath = "(//mat-option[@role='option']/span)[1]")
    private WebElement gradeLevel2;

//    @FindBy(xpath = "(//span[@class='mat-button-wrapper'])[20]")
//    private WebElement saveFormButton;



    WebElement myElement;

    public void findAndClick(String strElement){

        switch (strElement){
            case "academicPeriod":  myElement = academicPeriod; break;
            case "academicPeriod1" : myElement = academicPeriod1; break;
            case "gradeLevel" : myElement = gradeLevel; break;
            case "gradeLevel2" : myElement = gradeLevel2; break;
          //  case "saveFormButton" : myElement = saveFormButton; break;

        }
        clickFunction(myElement); //parent dan cagirdik

        if (myElement == academicPeriod || myElement == gradeLevel)
            BaseDriver.wait(2); // her seferinde tiklatip bekleyecek

    }

    public void searchAndDelete(String searchText){
        findAndSend("searchInput",searchText); //arama kutucuguna kelimeyi yaz
        findAndClick("searchButton"); //aram butununa bas

        // delete kismina gelinceye kadar cok hizli oldugu icin bekleme koyuyoruz ki bulup silsin. AMA GEREK YOK BU OLMADAN ZATEN SILDI BENDE
//        WebDriverWait wait = new WebDriverWait(BaseDriver.getDriver(), Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.stalenessOf(deleteButton));

        // BaseDriver.wait(2);  //hoca da bununla calisti. ama kullanilacak son method

        waitUntilLoading(); // parent da koydugumuz methodu buraya cagirip bekleme yaptiriyoruz. search button unu calistirdiginda sayfanin yuklenmesi kisminda bekliyor

        findAndClick("deleteButton"); //silme butonuna bas
        findAndClick("deleteDialogBtn"); //dialogdaki silme butununa bas

    }

    private void findAndSend(String searchInput, String searchText) {
    }


}
