package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(


        tags = "@Regression",
        features = {"src/test/java/FeatureFiles/"},
        glue = {"StepDefinitions"},

        plugin = {"html:target\\cucumber-reports.html"}  // html cinsinden target in altinda "cucumber-reports.html" isimde bir rapor olusturmus oluyor
                                                         // bu en basit raporlardan biri.
                                                         /** // bu sekilde de kullanabiliriz */
)

public class _06_TestRunnerRegressionWithPlugin extends AbstractTestNGCucumberTests {
}
