package Pages;

import Utilities.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftNav extends Parent{

    public LeftNav(){
        PageFactory.initElements(BaseDriver.getDriver(),this);
    }

    @FindBy(xpath = "(//span[text()='Setup'])[1]")
    private WebElement setupOne;

    @FindBy(xpath = "(//span[text()='Parameters'])[1]")
    private WebElement parameters;

    @FindBy(xpath = "(//span[text()='Countries'])[1]")
    private WebElement countries;

    @FindBy(xpath = "(//span[text()='Citizenships'])[1]")
    private WebElement citizenship;

    @FindBy(xpath = "//span[text()='Nationalities']")
    private WebElement nationalities;

    @FindBy(xpath = "//span[text()='Fees']")
    private WebElement fees;



    WebElement myElement;

    public void findAndClick(String strElement) {

        switch (strElement) {
            case "setupOne": myElement = setupOne; break;
            case "parameters": myElement = parameters; break;
            case "countries": myElement = countries; break;
            case "citizenship": myElement = citizenship; break;
            case "nationalities": myElement = nationalities; break;
            case "fees": myElement = fees; break;

        }

        clickFunction(myElement);
    }




    }
