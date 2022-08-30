package Runners;

import com.aventstack.extentreports.service.ExtentService;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;

@CucumberOptions(


        tags = "@Regression",
        features = {"src/test/java/FeatureFiles/"},
        glue = {"StepDefinitions"}
)

/** @Listeners  ->  "ExtentITestListenerClassAdapter" rapor olarak calisan bu modulu dinleyecek. */
@Listeners({ExtentITestListenerClassAdapter.class})
public class _07_TestRunnerExtentReport extends AbstractTestNGCucumberTests {

    @AfterClass
    public static void writeExtentReport() {  //aldigimiz rapora notlar ekleyebilecegimiz bolum yaptik

        ExtentService.getInstance().setSystemInfo("User Name", "Funda Akhan");
        ExtentService.getInstance().setSystemInfo("Application Name", "Campus");
        ExtentService.getInstance().setSystemInfo("Operating System Info", System.getProperty("os.name").toString());
        ExtentService.getInstance().setSystemInfo("Department", "QA");
        ExtentService.getInstance().setSystemInfo("Additional Line", "Description");
    }

}
