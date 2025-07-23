package stepDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.SeleniumDriver;

public class Hooks {

	public WebDriver driver;

	@Before
	public void setUp() {
		SeleniumDriver.setUpDriver();
	}

	@After
	public void tearDown(Scenario scenario) {
		WebDriver driver = SeleniumDriver.getDriver();

		if (scenario.isFailed()) {
			// Get screenshot as Base64
			String base64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

			// Create HTML <img> tag with Base64
			String base64Img = "<img src='data:image/png;base64, " + base64 + "' height='400' width='600' />";

			// Log HTML to ExtentReport
			ExtentCucumberAdapter.addTestStepLog("❌ Scenario failed. Screenshot:<br>" + base64Img);
		}

		SeleniumDriver.tearDown();
	}

}
