package Pages;

import Utilities.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Parent {
/** her POM da kullanabilmek icin Parent class actik */
// ben Parent isminde bir tane foknsiyon yaptim. bu fonksiyon POM ortak fonksiyonlarini
// buradan aliyor

   public void sendKeysFunction(WebElement element, String value){
/** 3. asama parent in cagrilan fonksiyonu */
       waitUntilVisible(element); // gozukene kadar bekle
       scrollToElement(element);   // elemente scroll yap
       element.clear();       // input kutucugunu temizle
       element.sendKeys(value);          // degeri gonder


   }

    public void waitUntilVisible(WebElement element){

        // beklemeyi yap
        WebDriverWait wait = new WebDriverWait(BaseDriver.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void scrollToElement(WebElement element){

        // kaydirmayi yap
        JavascriptExecutor js = (JavascriptExecutor) BaseDriver.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);

    }

    public void clickFunction(WebElement element){

        waitUntilClickable(element);  // clickable olana kadar bekle
        scrollToElement(element);     // kaydirmayi yap
        element.click();              // click yap


   }

    public void waitUntilClickable(WebElement element){

        // element clickable olana kadar beklemeyi yap
        WebDriverWait wait = new WebDriverWait(BaseDriver.getDriver(), Duration.ofSeconds(40));
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    public void verifyContainsText(WebElement element, String text){

       waitUntilVisible(element);  // gozukene kadar bekle
        Assert.assertTrue(element.getText().toLowerCase().contains(text.toLowerCase()));

   }

    public void waitUntilLoading(){
        WebDriverWait wait = new WebDriverWait(BaseDriver.getDriver(),Duration.ofSeconds(30));

        //fuse-progress-bar in child lari 0 olana kadar bekle methodu
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("fuse-progress-bar > *"),0));
    }






}
