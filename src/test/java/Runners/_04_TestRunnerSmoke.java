package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(

        tags = "@SmokeTest", // hangi seneryolarda bu etiket varsa onlar calistirilacak
        features = {"src/test/java/FeatureFiles/"}, //hicbir class eklemedik hepsini otomatik alip calistirir
        glue = {"StepDefinitions"}
       , plugin= {"pretty","html:target/site/cucumber-pretty","json:target/cucumber/cucumber.json"} // Jenkins icin plugin ekledik

)

public class _04_TestRunnerSmoke extends AbstractTestNGCucumberTests {


}
