package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {

    // Bana ne lazim:  1- browser tipi lazim burada ona gore olusturucam
    // her bir parallel calisan surec icin sadece o surece ozel STATIC bir degisken lazim
    // cunku runner class daki isaret edilen tum senaryolarda aynisinin calismasi lazim.
    // yani her pipeline icin (Local) ve de ona ozel static bir driver a ihtiyacim var
    // donanimdaki adi PIPELINE, yazilimdaki adi THREAD , parallel calisan bir surec

    public static WebDriver driver; // bunun yerine artik altindakini kullanicaz

    /** bu baseDriverin yeni hali parallel test olsa da calisacak olmasa da calisacak */
    private static ThreadLocal<WebDriver>  threadDriver = new ThreadLocal<>();
    // bu icerisinde WebDriver 1 WebDriver 2 yi yi tanimlicak
    // bu bana her bir hat da vericek. her bir hattin browser i var

    public static ThreadLocal<String> threadBrowserName = new ThreadLocal<>(); // chrome, firefox..

    // threadDriver.get() -> ilgili thread deki driver i verecek
    // threadDriver.set(driver) -> ilgili thread ile driver set ediliyor



    public static WebDriver getDriver(){


        /** extent report  turkce bilgi calismamasi sebebiyle kondu. dil ile alakali cikaca problemler olursa diye bunu ekledik cucumber in son dersinde. cok da onemli degil */
//        Locale.setDefault(new Locale("EN"));
//        System.setProperty("user.language", "EN");

        // terminaldeki kirmizi uyari yazilarini kaldirmak icin yaptik
        Logger.getLogger("").setLevel(Level.SEVERE);
        System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY,"Error"); // terminalde ilk basta cikan kirmizi iki satirlik uyari yazisini kaldirmak icin kullandik


        if (threadBrowserName.get() == null) //parallel calismayan yani XML den parametreyle gelmeyen leri cagiramak icin
            threadBrowserName.set("chrome"); // Basic arayanlar icin



        if (threadDriver.get() == null) { // yok ise olustur diyoruz.

            String browserName = threadBrowserName.get(); // bu thread deki browserName i verdi.

            switch ((browserName)){
                case "chrome" :
                   // System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
                    WebDriverManager.chromedriver().setup(); // setup kisminda artik eski setproperty yazmamiza gerek kalmadi
                    threadDriver.set(new ChromeDriver());  // bu thread e chrome istenmisse ve yoksa bir tane ekleniyor
                    break;

                case "firefox" :
                    // firefox icin de bu sekilde yapicaz ya da diger browserlar icin aynisi
                 //   System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
                    WebDriverManager.firefoxdriver().setup();
                    threadDriver.set(new FirefoxDriver());  // bu thread e firefox istenmisse ve yoksa bir tane ekleniyor
                    break;

                case "safari" :
                    WebDriverManager.safaridriver().setup();
                    threadDriver.set(new SafariDriver());
                    break;

                case "edge" :
                    WebDriverManager.edgedriver().setup();
                    threadDriver.set(new EdgeDriver());
                    break;

            }
        }

        return threadDriver.get();
    }

    public static void quitDriver() {
        wait(5);

        if (threadDriver.get() != null) {
            threadDriver.get().quit();  //buraya geldiginde o an o hatta hangi driver varsa onu quit yapacak

            WebDriver driver1 = threadDriver.get();
            driver = null;
            threadDriver.set(driver1);  //tekrar gelirse ici bos olmus olsun
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
