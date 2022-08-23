package Pages;

import Utilities.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy(xpath = "//ms-save-button[@class='ng-star-inserted']") // //ms-save-button//button
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(text(), 'successfully')]") 
    private WebElement successMessage;



    /** 2. asamaya burasi */
    WebElement myElement;
    public void findAndSend(String strElement, String value){

        switch (strElement){
            case "username":  myElement = username; break;
            case "password":  myElement = password; break;
            case "nameInput":  myElement = nameInput; break;
            case "codeInput":  myElement = codeInput; break;
        }

        sendKeysFunction(myElement , value); 
    }

    public void findAndClick(String strElement){

        switch (strElement){
            case "loginButton" : myElement = loginButton; break;
            case "addButton": myElement = addButton; break;
            case "saveButton": myElement = saveButton; break;
        }

        clickFunction(myElement); //parent dan cagirdik
    }

    public void findAndContainsText(String strElement , String text){

        switch (strElement){
            case "dashboard" : myElement = dashboard; break;
            case "successMessage" : myElement = successMessage; break;
        }

        verifyContainsText(myElement,text);
    }



}
