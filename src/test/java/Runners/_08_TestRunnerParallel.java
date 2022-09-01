package Runners;

import Utilities.BaseDriver;
import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@CucumberOptions(

        tags = "@Regression", // hangi seneryolarda bu etiket varsa onlar calistirilacak
        features = {"src/test/java/FeatureFiles/"},
        glue = {"StepDefinitions"}


)


public class _08_TestRunnerParallel extends AbstractTestNGCucumberTests {

    @BeforeClass(alwaysRun = true) //bazi java version hatalarina karsi alwayRun kullaniyoruz
    @Parameters("browser")
    public void beforeClass(String browser){
        //burada browser set edilecek. yani BaseDriver ile baglantisini yapicaz. set edince BaseDriver i etkilemesi lazim ki oradan hangi driver i acacagina karar vericek

        BaseDriver.threadBrowserName.set(browser); // bu thread e browserName set edildi

    }




}
