package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/FeatureFiles/_01_Login.feature"}, // buraya feature files in path i verilecek
        glue = {"StepDefinitions"}      // Step definitions in klasoru yaziliyor
)
public class _01_TestRunner extends AbstractTestNGCucumberTests {


}
