package pages.base;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.SeleniumDriver;

public class BasePage {

	public static WebDriver driver;
	private WebElement mouseOverElement;
	private WebElement selectElement;
	private List<WebElement> sortListWebElements;
	List<Double> carPrice = new ArrayList<Double>();
	WebDriverWait wait;

	public BasePage() {
		driver = SeleniumDriver.getDriver();
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void mouseOver(String locator) {

		if (locator.endsWith("_XPATH")) {
			mouseOverElement = wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.xpath(SeleniumDriver.OR.getProperty(locator)))));
			// mouseOverElement =
			// driver.findElement(By.xpath(SeleniumDriver.OR.getProperty(locator)));
		}

		if (locator.endsWith("_ID")) {
			mouseOverElement = wait.until(
					ExpectedConditions.visibilityOf(driver.findElement(By.id(SeleniumDriver.OR.getProperty(locator)))));
		}

		if (locator.endsWith("_CSS")) {
			mouseOverElement = wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.cssSelector(SeleniumDriver.OR.getProperty(locator)))));
		}

		if (locator.endsWith("_LINKTEXT")) {
			mouseOverElement = driver.findElement(By.linkText(SeleniumDriver.OR.getProperty(locator)));
		}

		new Actions(driver).moveToElement(mouseOverElement).perform();
	}

	public void click(String locator) {

		if (locator.endsWith("_XPATH")) {
			wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.xpath(SeleniumDriver.OR.getProperty(locator))))).click();
		}

		if (locator.endsWith("_ID")) {
			wait.until(
					ExpectedConditions.visibilityOf(driver.findElement(By.id(SeleniumDriver.OR.getProperty(locator)))))
					.click();
		}

		if (locator.endsWith("_CSS")) {
			wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.cssSelector(SeleniumDriver.OR.getProperty(locator))))).click();
		}

		if (locator.endsWith("_LINKTEXT")) {
			wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.linkText(SeleniumDriver.OR.getProperty(locator))))).click();
		}

		if (locator.endsWith("_CLASSNAME")) {
			wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.className(SeleniumDriver.OR.getProperty(locator))))).click();
		}

	}

	public boolean isElementPresent(String locator) {

		try {
			if (locator.endsWith("_XPATH")) {
				wait.until(ExpectedConditions
						.visibilityOf(driver.findElement(By.xpath(SeleniumDriver.OR.getProperty(locator)))));
			}

			else if (locator.endsWith("_ID")) {
				wait.until(ExpectedConditions
						.visibilityOf(driver.findElement(By.id(SeleniumDriver.OR.getProperty(locator)))));
			}

			else if (locator.endsWith("_CSS")) {
				wait.until(ExpectedConditions
						.visibilityOf(driver.findElement(By.cssSelector(SeleniumDriver.OR.getProperty(locator)))));
			}

			else if (locator.endsWith("_LINKTEXT")) {
				wait.until(ExpectedConditions
						.visibilityOf(driver.findElement(By.linkText(SeleniumDriver.OR.getProperty(locator)))));
			}
			return true;
		} catch (Throwable t) {
			return false;
		}
	}

	public void type(String locator, String value) {

		if (locator.endsWith("_XPATH")) {
			wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.xpath(SeleniumDriver.OR.getProperty(locator)))))
					.sendKeys(value);
		}

		if (locator.endsWith("_ID")) {
			wait.until(
					ExpectedConditions.visibilityOf(driver.findElement(By.id(SeleniumDriver.OR.getProperty(locator)))))
					.sendKeys(value);
		}

		if (locator.endsWith("_CSS")) {
			wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.cssSelector(SeleniumDriver.OR.getProperty(locator)))))
					.sendKeys(value);
		}

		if (locator.endsWith("_LINKTEXT")) {
			wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.linkText(SeleniumDriver.OR.getProperty(locator)))))
					.sendKeys(value);
		}

		if (locator.endsWith("_CLASSNAME")) {
			wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.className(SeleniumDriver.OR.getProperty(locator)))))
					.sendKeys(value);
		}

	}

	public String getText(String locator) {

		if (locator.endsWith("_XPATH")) {
			return wait
					.until(ExpectedConditions
							.visibilityOf(driver.findElement(By.xpath(SeleniumDriver.OR.getProperty(locator)))))
					.getText();

		}

		if (locator.endsWith("_ID")) {
			return wait
					.until(ExpectedConditions
							.visibilityOf(driver.findElement(By.xpath(SeleniumDriver.OR.getProperty(locator)))))
					.getText();
		}

		if (locator.endsWith("_CSS")) {
			return wait
					.until(ExpectedConditions
							.visibilityOf(driver.findElement(By.xpath(SeleniumDriver.OR.getProperty(locator)))))
					.getText();
		}

		if (locator.endsWith("_LINKTEXT")) {
			return wait
					.until(ExpectedConditions
							.visibilityOf(driver.findElement(By.xpath(SeleniumDriver.OR.getProperty(locator)))))
					.getText();
		}
		return "No Car Present";

	}

	public void declineJavaPopups() {
		driver.switchTo().alert().dismiss();
	}

	public void acceptJavaPopups() {
		driver.switchTo().alert().accept();
	}

	public void selectDropDown(String locator, String selectByValue) {

		if (locator.endsWith("_XPATH")) {
			selectElement = wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.xpath(SeleniumDriver.OR.getProperty(locator)))));
		}

		if (locator.endsWith("_ID")) {
			selectElement = wait.until(
					ExpectedConditions.visibilityOf(driver.findElement(By.id(SeleniumDriver.OR.getProperty(locator)))));
		}

		if (locator.endsWith("_CSS")) {
			selectElement = wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.cssSelector(SeleniumDriver.OR.getProperty(locator)))));
		}

		if (locator.endsWith("_LINKTEXT")) {
			selectElement = wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.linkText(SeleniumDriver.OR.getProperty(locator)))));
		}

		Select select = new Select(selectElement);
		select.selectByVisibleText(selectByValue);
	}

	public boolean verifyDescendingSort(String locator) {
		if (locator.endsWith("_XPATH")) {
			sortListWebElements = wait.until(ExpectedConditions
					.visibilityOfAllElements(driver.findElements(By.xpath(SeleniumDriver.OR.getProperty(locator)))));
		}

		if (locator.endsWith("_ID")) {
			sortListWebElements = wait.until(ExpectedConditions
					.visibilityOfAllElements(driver.findElements(By.id(SeleniumDriver.OR.getProperty(locator)))));
		}

		if (locator.endsWith("_CSS")) {
			sortListWebElements = wait.until(ExpectedConditions.visibilityOfAllElements(
					driver.findElements(By.cssSelector(SeleniumDriver.OR.getProperty(locator)))));
		}

		if (locator.endsWith("_LINKTEXT")) {
			sortListWebElements = wait.until(ExpectedConditions
					.visibilityOfAllElements(driver.findElements(By.linkText(SeleniumDriver.OR.getProperty(locator)))));
		}

		for (WebElement item : sortListWebElements) {
			String price = item.getText();
			String[] parts = price.split(" ");
			String number = parts[1]; // "10"
			carPrice.add(Double.parseDouble(number));
		}

		for (int i = 0; i < carPrice.size() - 1; i++) {
			if (carPrice.get(i) < carPrice.get(i + 1)) {
				return false;
			}

		}
		return true;
	}

}
