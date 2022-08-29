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
    private WebElement  gradeLevel1;

    @FindBy(xpath = "(//mat-option[@role='option']/span)[2]")
    private WebElement gradeLevel2;

    @FindBy(xpath = "(//mat-option[@role='option']/span)[3]")
    private WebElement gradeLevel3;

    @FindBy(xpath = "(//mat-option[@role='option']/span)[4]")
    private WebElement  gradeLevel4;

    @FindBy(xpath = "(//mat-option[@role='option']/span)[5]")
    private WebElement  gradeLevel5;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='firstName']//input")
    private WebElement firstname;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='lastName']//input")
    private WebElement lastName;

    @FindBy(xpath = "//input[@formcontrolname='employeeId']")
    private WebElement employeeId;

    @FindBy(xpath = "//mat-select[@formcontrolname='gender']")
    private WebElement gender;

    @FindBy(xpath = "//*[@id='mat-option-3115']/span")
    private WebElement female;

    @FindBy(xpath = "//mat-select[@formcontrolname='types']")
    private WebElement employeeType;

    @FindBy(xpath = "//mat-option[@id='mat-option-1626']")
    private WebElement teacher;

    @FindBy(xpath = "//mat-select[@formcontrolname='qualification']")
    private WebElement qualification;

    @FindBy(xpath = "(//div[@id='mat-select-154-panel'])//mat-option[4]")
    private WebElement master;







    WebElement myElement;

    public void findAndClick(String strElement){

        switch (strElement){
            case "academicPeriod":  myElement = academicPeriod; break;
            case "academicPeriod1" : myElement = academicPeriod1; break;
            case "gradeLevel" : myElement = gradeLevel; break;
            case "gradeLevel1" : myElement = gradeLevel1; break;
            case "gradeLevel2" : myElement = gradeLevel2; break;
            case "gradeLevel3" : myElement = gradeLevel3; break;
            case "gradeLevel4" : myElement = gradeLevel4; break;
            case "gradeLevel5" : myElement = gradeLevel5; break;
            case "gender" : myElement = gender; break;
            case "female" : myElement = female; break;
            case "employeeType" : myElement = employeeType; break;
            case "teacher" : myElement = teacher; break;
            case "qualification" : myElement = qualification; break;
            case "master" : myElement = master; break;


        }
        clickFunction(myElement); //parent dan cagirdik

        if (myElement == academicPeriod || myElement == gradeLevel)
            waitUntilLoading(); // her seferinde tiklatip bekleyecek

        if (myElement == gender || myElement == employeeType || myElement == qualification)
            waitUntilLoading();

    }

    public void findAndSend(String strElement, String value){

        switch (strElement){
            case "firstname" : myElement = firstname; break;
            case "lastName" : myElement = lastName; break;
            case "employeeId" : myElement = employeeId; break;
        }

        sendKeysFunction(myElement,value);
    }









}
