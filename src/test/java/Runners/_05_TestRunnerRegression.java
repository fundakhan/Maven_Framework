package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(  // or oldugunda herhangi bir tanesi varsa calistirir
                   // and oldugunda her ikisinin de senaryoda tag olarak olan senaryolari calistirir

        tags = "@Regression or @SmokeTest", // hangi seneryolarda bu etiket varsa onlar calistirilacak
        features = {"src/test/java/FeatureFiles/"}, //hicbir class eklemedik hepsini otomatik alip calistirir
        glue = {"StepDefinitions"}

)

public class _05_TestRunnerRegression extends AbstractTestNGCucumberTests {

   /** bu bolum -> browser tipi vermek icin, rapora ek parametre eklemek icin kullaniliyor */
}
