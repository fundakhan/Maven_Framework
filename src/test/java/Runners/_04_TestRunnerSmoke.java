package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(

        tags = "@SmokeTest", // hangi seneryolarda bu etiket varsa onlar calistirilacak
        features = {"src/test/java/FeatureFiles/"}, //hicbir class eklemedik hepsini otomatik alip calistirir
        glue = {"StepDefinitions"}

)

public class _04_TestRunnerSmoke extends AbstractTestNGCucumberTests {


}
