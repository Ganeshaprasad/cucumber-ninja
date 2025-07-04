package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features",glue = {"stepdefination","hooks"} , plugin = {
        "pretty",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
},
        monochrome = true



)
public class TestRunner extends AbstractTestNGCucumberTests {

}
