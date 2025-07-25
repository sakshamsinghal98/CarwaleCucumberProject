package pages.base;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SeleniumDriver;

public class BasePage {

	public static WebDriver driver;
	private WebElement mouseOverElement;
	private WebElement selectElement;
	private List<WebElement> sortListWebElements;
	private List<String> carNames = new ArrayList<String>();
	private List<String> carPrices = new ArrayList<String>();
	private String elementColor;
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
		}

		else if (locator.endsWith("_ID")) {
			mouseOverElement = wait.until(
					ExpectedConditions.visibilityOf(driver.findElement(By.id(SeleniumDriver.OR.getProperty(locator)))));
		}

		else if (locator.endsWith("_CSS")) {
			mouseOverElement = wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.cssSelector(SeleniumDriver.OR.getProperty(locator)))));
		}

		else if (locator.endsWith("_LINKTEXT")) {
			mouseOverElement = wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.linkText(SeleniumDriver.OR.getProperty(locator)))));
		}

		new Actions(driver).moveToElement(mouseOverElement).perform();
	}

	public void click(String locator) {

		if (locator.endsWith("_XPATH")) {
			wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.xpath(SeleniumDriver.OR.getProperty(locator))))).click();
		}

		else if (locator.endsWith("_ID")) {
			wait.until(
					ExpectedConditions.visibilityOf(driver.findElement(By.id(SeleniumDriver.OR.getProperty(locator)))))
					.click();
		}

		else if (locator.endsWith("_CSS")) {
			wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.cssSelector(SeleniumDriver.OR.getProperty(locator))))).click();
		}

		else if (locator.endsWith("_LINKTEXT")) {
			wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.linkText(SeleniumDriver.OR.getProperty(locator))))).click();
		}

		else if (locator.endsWith("_CLASSNAME")) {
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

		else if (locator.endsWith("_ID")) {
			wait.until(
					ExpectedConditions.visibilityOf(driver.findElement(By.id(SeleniumDriver.OR.getProperty(locator)))))
					.sendKeys(value);
		}

		else if (locator.endsWith("_CSS")) {
			wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.cssSelector(SeleniumDriver.OR.getProperty(locator)))))
					.sendKeys(value);
		}

		else if (locator.endsWith("_LINKTEXT")) {
			wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.linkText(SeleniumDriver.OR.getProperty(locator)))))
					.sendKeys(value);
		}

		else if (locator.endsWith("_CLASSNAME")) {
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

		else if (locator.endsWith("_ID")) {
			return wait
					.until(ExpectedConditions
							.visibilityOf(driver.findElement(By.xpath(SeleniumDriver.OR.getProperty(locator)))))
					.getText();
		}

		else if (locator.endsWith("_CSS")) {
			return wait
					.until(ExpectedConditions
							.visibilityOf(driver.findElement(By.xpath(SeleniumDriver.OR.getProperty(locator)))))
					.getText();
		}

		else if (locator.endsWith("_LINKTEXT")) {
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

		else if (locator.endsWith("_ID")) {
			selectElement = wait.until(
					ExpectedConditions.visibilityOf(driver.findElement(By.id(SeleniumDriver.OR.getProperty(locator)))));
		}

		else if (locator.endsWith("_CSS")) {
			selectElement = wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.cssSelector(SeleniumDriver.OR.getProperty(locator)))));
		}

		else if (locator.endsWith("_LINKTEXT")) {
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

		else if (locator.endsWith("_ID")) {
			sortListWebElements = wait.until(ExpectedConditions
					.visibilityOfAllElements(driver.findElements(By.id(SeleniumDriver.OR.getProperty(locator)))));
		}

		else if (locator.endsWith("_CSS")) {
			sortListWebElements = wait.until(ExpectedConditions.visibilityOfAllElements(
					driver.findElements(By.cssSelector(SeleniumDriver.OR.getProperty(locator)))));
		}

		else if (locator.endsWith("_LINKTEXT")) {
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

	public void verifyIfImagesAreGettingDisplayedOrNot() {
		List<WebElement> images = driver.findElements(By.tagName("img"));
		int broken = 0;
		for (WebElement image : images) {
			boolean isDisplayed = (Boolean) ((JavascriptExecutor) driver)
					.executeScript("return arguments[0].complete && arguments[0].naturalWidth > 0", image);
			if (!isDisplayed) {
				System.out.println("❌ Broken image: " + image.getAttribute("src"));
				broken++;
			}
		}
		if (broken == 0) {
			System.out.println("✅ All images are loading properly.");
		} else {
			System.out.println("Total broken images: " + broken);
		}

	}

	public boolean veriyColorCoding(String locator, String expectedColor) {

		if (locator.endsWith("_XPATH")) {
			elementColor = wait
					.until(ExpectedConditions
							.visibilityOf(driver.findElement(By.xpath(SeleniumDriver.OR.getProperty(locator)))))
					.getCssValue("background-color");
		}

		else if (locator.endsWith("_ID")) {
			elementColor = wait
					.until(ExpectedConditions
							.visibilityOf(driver.findElement(By.id(SeleniumDriver.OR.getProperty(locator)))))
					.getCssValue("background-color");
		}

		else if (locator.endsWith("_CSS")) {
			elementColor = wait
					.until(ExpectedConditions
							.visibilityOf(driver.findElement(By.cssSelector(SeleniumDriver.OR.getProperty(locator)))))
					.getCssValue("background-color");
		}

		else if (locator.endsWith("_LINKTEXT")) {
			elementColor = wait
					.until(ExpectedConditions
							.visibilityOf(driver.findElement(By.linkText(SeleniumDriver.OR.getProperty(locator)))))
					.getCssValue("background-color");
		}

		String hexColor = Color.fromString(elementColor).asHex();
		if (hexColor.equals(expectedColor)) {
			System.out.println(hexColor);
			return true;
		}
		return false;
	}

	public List<List<String>> getCarNameAndPrice(String carNameLocator, String carPriceLocator) {

		if (carNameLocator.endsWith("_XPATH")) {
			List<WebElement> carNamesWebElements = wait.until(ExpectedConditions.visibilityOfAllElements(
					driver.findElements(By.cssSelector(SeleniumDriver.OR.getProperty(carNameLocator)))));
			for (WebElement carName : carNamesWebElements) {
				carNames.add(carName.getText());
			}
			System.out.println(carNames);
		}

		else if (carNameLocator.endsWith("_ID")) {
			List<WebElement> carNamesWebElements = wait.until(ExpectedConditions.visibilityOfAllElements(
					driver.findElements(By.cssSelector(SeleniumDriver.OR.getProperty(carNameLocator)))));

			for (WebElement carName : carNamesWebElements) {
				carNames.add(carName.getText());

			}
			System.out.println(carNames);
		}

		else if (carNameLocator.endsWith("_CSS")) {

			List<WebElement> carNamesWebElements = wait.until(ExpectedConditions.visibilityOfAllElements(
					driver.findElements(By.cssSelector(SeleniumDriver.OR.getProperty(carNameLocator)))));

			for (WebElement carName : carNamesWebElements) {
				String car = carName.getText();
				carNames.add(car);

			}
			System.out.println(carNames);

		}

		else if (carNameLocator.endsWith("_LINKTEXT")) {
			List<WebElement> carNamesWebElements = wait.until(ExpectedConditions.visibilityOfAllElements(
					driver.findElements(By.cssSelector(SeleniumDriver.OR.getProperty(carNameLocator)))));

			for (WebElement carName : carNamesWebElements) {
				carNames.add(carName.getText());
			}
			System.out.println(carNames);

		}

		if (carPriceLocator.endsWith("_XPATH")) {
			List<WebElement> carPriceWebElements = wait.until(ExpectedConditions.visibilityOfAllElements(
					driver.findElements(By.cssSelector(SeleniumDriver.OR.getProperty(carPriceLocator)))));

			for (WebElement pricecar : carPriceWebElements) {
				carPrices.add(pricecar.getText());

			}
			System.out.println(carPrices);
		}

		else if (carPriceLocator.endsWith("_ID")) {
			List<WebElement> carPriceWebElements = wait.until(ExpectedConditions.visibilityOfAllElements(
					driver.findElements(By.cssSelector(SeleniumDriver.OR.getProperty(carPriceLocator)))));

			for (WebElement pricecar : carPriceWebElements) {
				carPrices.add(pricecar.getText());

			}
			System.out.println(carPrices);

		}

		else if (carPriceLocator.endsWith("_CSS")) {
			List<WebElement> carPriceWebElements = wait.until(ExpectedConditions.visibilityOfAllElements(
					driver.findElements(By.cssSelector(SeleniumDriver.OR.getProperty(carPriceLocator)))));

			for (WebElement pricecar : carPriceWebElements) {
				carPrices.add(pricecar.getText());
			}
			System.out.println(carPrices);

		}

		else if (carPriceLocator.endsWith("_LINKTEXT")) {
			List<WebElement> carPriceWebElements = wait.until(ExpectedConditions.visibilityOfAllElements(
					driver.findElements(By.cssSelector(SeleniumDriver.OR.getProperty(carPriceLocator)))));

			for (WebElement pricecar : carPriceWebElements) {
				carPrices.add(pricecar.getText());
			}
			System.out.println(carPrices);

		}

		return List.of(carNames, carPrices);
	}

	public void exportToExcel(List<List<String>> nameAndPriceList) {
		carNames = nameAndPriceList.get(0);
		carPrices = nameAndPriceList.get(1);
		String filePath = "E://Selenium Frameworks//Car Name And Prices.xlsx";
		System.out.println("--------------------We are under the exort to Excel Mothod--------------------------- ");
		System.out.println(carNames);
		System.out.println(carPrices);

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Toyota Car Name and Pricing");

		while (sheet.getPhysicalNumberOfRows() > 0) {
			sheet.removeRow(sheet.getRow(0));
		}

		Row headerrow = sheet.createRow(0);
		headerrow.createCell(0).setCellValue("Car Name");
		headerrow.createCell(1).setCellValue("Car Price");

		for (int i = 0; i < carPrices.size(); i++) {
			Row row = sheet.createRow(i + 1);
			row.createCell(0).setCellValue(carNames.get(i));
			row.createCell(1).setCellValue(carPrices.get(i));
		}

		try {
			FileOutputStream fos = new FileOutputStream(filePath);
			workbook.write(fos);
			workbook.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
