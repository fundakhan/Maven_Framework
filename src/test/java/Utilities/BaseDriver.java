package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {

    public static WebDriver driver;

    public static WebDriverWait wait;

    public static WebDriver getDriver(){

        if (driver == null) { // yok ise olustur diyoruz.

            // terminaldeki kirmizi uyari yazilarini kaldirmak icin yaptik
            Logger.getLogger("").setLevel(Level.SEVERE);
            System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY,"Error"); // terminalde ilk basta cikan kirmizi iki satirlik uyari yazisini kaldirmak icin kullandik
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");

            WebDriverManager.chromedriver().setup(); // setup kisminda artik eski setproperty yazmamiza gerek kalmadi
            driver = new ChromeDriver();

            // firefox icin de bu sekilde yapicaz ya da diger browserlar icin aynisi
    //        WebDriverManager.firefoxdriver().setup();
    //        driver = new FirefoxDriver();
        }

         wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return driver;
    }

    public static void quitDriver() {

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        if (driver != null) { // driver varsa kapat
          //  driver.quit();
            driver = null; //driver in hafizasini bosaltsin
        }
    }

    public static void wait(int second){

        try {
            Thread.sleep(second* 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
