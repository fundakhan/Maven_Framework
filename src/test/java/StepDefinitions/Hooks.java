package StepDefinitions;

import Utilities.BaseDriver;
import com.aventstack.extentreports.service.ExtentTestManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hooks {

    @Before
    public void before(){

        System.out.println("Scenario Started!");

    }
    @After
    public void after(Scenario scenario){ // screenshot icin parametre vermemiz gerekiyor

        System.out.println("Scenario is done!");
        System.out.println("Scenario result : " + scenario.getStatus());
        System.out.println("Scenario isFailed ? : " + scenario.isFailed());

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM.dd.yy");

        if (scenario.isFailed()){  // her scenario icin gecerli. eger failed ise screenshot al methodu
            // klosore
            TakesScreenshot screenshot = (TakesScreenshot) BaseDriver.getDriver();
            File screenFile = screenshot.getScreenshotAs(OutputType.FILE);

            // Extent Report a ekliyor.. en altta ekledigim method dan aliyor
            ExtentTestManager.getTest().addScreenCaptureFromBase64String(getBase64Screenshot());

            try {

                FileUtils.copyFile(screenFile,
                        new File("target/FailedScreenShots/" + scenario.getId() + date.format(formatter) + ".png" ));
            }catch (IOException e){
                e.printStackTrace();
            }

        }



        // seneryo hatali ise ekran goruntusunu al
        BaseDriver.quitDriver();
    }

    public String getBase64Screenshot()
    {
        return ((TakesScreenshot) BaseDriver.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
