package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utils.SeleniumDriver;

public class BasePage {

	public static WebDriver driver;
	private WebElement mouseOverElement;

	public BasePage() {
		driver = SeleniumDriver.getDriver();
	}

	public void mouseOver(String locator) {

		if (locator.endsWith("_XPATH")) {
			mouseOverElement = driver.findElement(By.xpath(SeleniumDriver.OR.getProperty(locator)));
		}

		if (locator.endsWith("_ID")) {
			mouseOverElement = driver.findElement(By.id(SeleniumDriver.OR.getProperty(locator)));
		}

		if (locator.endsWith("_CSS")) {
			mouseOverElement = driver.findElement(By.cssSelector(SeleniumDriver.OR.getProperty(locator)));
		}

		if (locator.endsWith("_LINKTEXT")) {
			mouseOverElement = driver.findElement(By.linkText(SeleniumDriver.OR.getProperty(locator)));
		}

		new Actions(driver).moveToElement(mouseOverElement).perform();
	}

	public void click(String locator) {

		if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(SeleniumDriver.OR.getProperty(locator))).click();
		}

		if (locator.endsWith("_ID")) {
			driver.findElement(By.id(SeleniumDriver.OR.getProperty(locator))).click();
		}

		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(SeleniumDriver.OR.getProperty(locator))).click();
		}

		if (locator.endsWith("_LINKTEXT")) {
			driver.findElement(By.linkText(SeleniumDriver.OR.getProperty(locator))).click();
		}

	}

	public boolean isElementPresent(String locator) {

		try {
			if (locator.endsWith("_XPATH")) {
				driver.findElement(By.xpath(SeleniumDriver.OR.getProperty(locator)));
			}

			else if (locator.endsWith("_ID")) {
				driver.findElement(By.id(SeleniumDriver.OR.getProperty(locator)));
			}

			else if (locator.endsWith("_CSS")) {
				driver.findElement(By.cssSelector(SeleniumDriver.OR.getProperty(locator)));
			}

			else if (locator.endsWith("_LINKTEXT")) {
				driver.findElement(By.linkText(SeleniumDriver.OR.getProperty(locator)));
			}
			return true;
		} catch (Throwable t) {
			return false;
		}
	}

	public void type(String locator, String value) {

		if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(SeleniumDriver.OR.getProperty(locator))).sendKeys(value);
		}

		if (locator.endsWith("_ID")) {
			driver.findElement(By.id(SeleniumDriver.OR.getProperty(locator))).sendKeys(value);
		}

		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(SeleniumDriver.OR.getProperty(locator))).sendKeys(value);
		}

		if (locator.endsWith("_LINKTEXT")) {
			driver.findElement(By.linkText(SeleniumDriver.OR.getProperty(locator))).sendKeys(value);
		}

	}

	public String getText(String locator) {

		if (locator.endsWith("_XPATH")) {
			return driver.findElement(By.xpath(SeleniumDriver.OR.getProperty(locator))).getText();

		}

		if (locator.endsWith("_ID")) {
			return driver.findElement(By.xpath(SeleniumDriver.OR.getProperty(locator))).getText();
		}

		if (locator.endsWith("_CSS")) {
			return driver.findElement(By.xpath(SeleniumDriver.OR.getProperty(locator))).getText();
		}

		if (locator.endsWith("_LINKTEXT")) {
			return driver.findElement(By.xpath(SeleniumDriver.OR.getProperty(locator))).getText();
		}
		return "No Car Present";

	}

	public void declineJavaPopups() {
		driver.switchTo().alert().dismiss();
	}

	public void acceptJavaPopups() {
		driver.switchTo().alert().accept();
	}
}
