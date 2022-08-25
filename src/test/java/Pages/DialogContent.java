package Pages;

import Utilities.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DialogContent extends Parent{

    public DialogContent(){
        PageFactory.initElements(BaseDriver.getDriver(),this);
    }

    @FindBy(id = "mat-input-0")
    private WebElement username;

    @FindBy(id = "mat-input-1")
    private WebElement password;

    @FindBy(css = "button[aria-label='LOGIN']")
    private WebElement loginButton;

    @FindBy(xpath = "(//span[contains(text(),'Dashboard')])[2]")
    private WebElement dashboard;

    @FindBy(xpath = "//ms-add-button[contains(@tooltip,'TITLE.ADD')]//button") 
    private WebElement addButton;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']//input")
    private WebElement nameInput;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='code']//input")
    private WebElement codeInput;

    @FindBy(xpath = "//ms-save-button//button") // //ms-save-button//button
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(text(), 'successfully')]") 
    private WebElement successMessage;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='shortName']//input")
    private WebElement shortName;

    @FindBy(xpath = "//div[contains(text(),'already exist')]")
    private WebElement alreadyExist;

    @FindBy(xpath = "//button[@aria-label='Close dialog']")
    private WebElement closeDialog;

    @FindBy(xpath = "(//div[contains(@class, 'mat-form-field-infix ng-tns-c74')]//input)[1]")
    private WebElement searchInput;

    @FindBy(xpath = "//ms-search-button//button")
    private WebElement searchButton;

    @FindBy(xpath = "//ms-delete-button//button")
    private WebElement deleteButton;

    @FindBy(xpath = "//span[contains(text(), 'Delete')]")
    private WebElement deleteDialogBtn;

    @FindBy(xpath = "//ms-text-field[contains(@placeholder, 'FIELD.INTEGRATION_CODE')]//input")
    private WebElement integrationCode;

    @FindBy(xpath = "//ms-integer-field[@formcontrolname='priority']//input")
    private WebElement priority;

    @FindBy(xpath = "(//button[@class='consent-give'])[1]")
    private WebElement acceptCookies;





    /** 2. asamaya burasi */
    WebElement myElement;
    public void findAndSend(String strElement, String value){

        switch (strElement){
            case "username":  myElement = username; break;
            case "password":  myElement = password; break;
            case "nameInput":  myElement = nameInput; break;
            case "codeInput":  myElement = codeInput; break;
            case "shortName":  myElement = shortName; break;
            case "searchInput":  myElement = searchInput; break;
            case "integrationCode":  myElement = integrationCode; break;
            case "priority":  myElement = priority; break;
        }

        sendKeysFunction(myElement , value); 
    }

    public void findAndClick(String strElement){

        switch (strElement){
            case "loginButton" : myElement = loginButton; break;
            case "addButton": myElement = addButton; break;
            case "saveButton": myElement = saveButton; break;
            case "closeDialog": myElement = closeDialog; break;
            case "searchButton": myElement = searchButton; break;
            case "deleteButton": myElement = deleteButton; break;
            case "deleteDialogBtn": myElement = deleteDialogBtn; break;
            case "acceptCookies": myElement = acceptCookies; break;
        }


        clickFunction(myElement); //parent dan cagirdik
    }

    public void findAndContainsText(String strElement , String text){

        switch (strElement){
            case "dashboard" : myElement = dashboard; break;
            case "successMessage" : myElement = successMessage; break;
            case "alreadyExist" : myElement = alreadyExist; break;
        }


        verifyContainsText(myElement,text);
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




}
