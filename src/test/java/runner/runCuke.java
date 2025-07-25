package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/", glue = { "stepDefinitions" }, tags = "@excelexport", plugin = {
		"html:target/cucumber-reports/cucumber-html-report.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })
public class runCuke extends AbstractTestNGCucumberTests {

}