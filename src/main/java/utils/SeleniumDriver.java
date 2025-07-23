package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumDriver {

	private static SeleniumDriver seleniumDriver;
	private static WebDriverWait waitDriver;
	private static WebDriver driver;

	public static Properties config = new Properties();
	public static Properties OR = new Properties();

	private FileInputStream fis;

	private SeleniumDriver() {
		try {
			fis = new FileInputStream(
					"E:\\Selenium Frameworks\\CucumberPageObjectFramework\\src\\main\\resources\\properties\\config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			config.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			fis = new FileInputStream(
					"E:\\Selenium Frameworks\\CucumberPageObjectFramework\\src\\main\\resources\\properties\\OR.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			OR.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (config.getProperty("browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		if (config.getProperty("browser").equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		if (config.getProperty("browser").equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();

		waitDriver = new WebDriverWait(driver,
				Duration.ofSeconds((Integer.parseInt(config.getProperty("explicit.wait")))));

		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicit.wait"))));

	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setUpDriver() {
		if (seleniumDriver == null) {
			seleniumDriver = new SeleniumDriver();
		}
	}

	public static void openWebsite(String url) {
		driver.get(url);
	}

	public static void tearDown() {
		if (driver != null) {
			driver.close();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			driver.quit();

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		seleniumDriver = null;

	}

}
