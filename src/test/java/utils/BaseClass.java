package utils;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.jar.asm.Handle;
import net.bytebuddy.utility.privilege.GetSystemPropertyAction;

import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.RenderingHints.Key;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseClass {

	public static WebDriver driver;
//	protected WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	protected ChromeOptions options;
	static Properties property = new Properties();
	static String single = "";

	protected static WebDriverWait wait;

	private void windowHandler() {
		this.driver = driver;
		this.single = driver.getWindowHandle();
	}

	public static void launchBrowser(String browser) {
		if (driver != null) {
			System.out.println("Browser already running.");
			return;
		}

		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}

	public static void openUrl(String url) {
		driver.get(url);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
	}

//    public static void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//	public static void launchBrowser(String browser) {
//		if (driver != null) {
//			System.out.println("Browser already running.");
//			return; // Don't create a new session if one is active
//		}
//		switch (browser.toLowerCase()) {
//		case "chrome":
//			WebDriverManager.chromedriver().setup();
//			if (driver == null) {
//				driver = new ChromeDriver();
//			}
//			break;
//		case "firefox":
//			driver = new FirefoxDriver();
//			break;
//		case "edge":
//			driver = new EdgeDriver();
//			break;
//		default:
//			throw new IllegalArgumentException("Unsupported browser: " + browser);
//		}
////		options.addArguments("--start-maximized");
////		options.addArguments("--disable-notifications");
//
////		driver.get(url);
//	}
//
//	public static void openUrl(String url) {
//		driver.get(url);
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//	}

	public WebElement waitForElementVisible(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void waitForElementClickable(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element)).click();
	}

	public void sendKeys(WebElement element, String text) {
		WebElement element2 = wait.until(ExpectedConditions.visibilityOf(element));
		element2.clear();
		element2.sendKeys(text);
	}

	public String getText(By locator) {
		return waitForElementVisible(locator).getText();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public static void tearDown() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

	public void verifyTextPresent(WebElement element, String message, String expectedText) {
		WebElement visibleElement = wait.until(ExpectedConditions.visibilityOf(element));
		String actualText = visibleElement.getText();
//		assert actualText.equals(expectedText);
		Assertions.assertEquals(actualText, expectedText, message);
	}

	public static void switchingWindow() {

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handling : windowHandles) {
			if (single != handling) {
				driver.switchTo().window(handling);

			}
		}
	}

	public static void switchingBack() {
		driver.switchTo().window(single);
	}

//	public static String getProperty(String key) throws IOException{
//		// Open the property file
//		try (FileInputStream fileInputStream = new FileInputStream(config)) {
//			Properties properties = new Properties();
//			properties.load(fileInputStream);
//
//			// Return the property value corresponding to the given key
//			return properties.getProperty(key);
//		} catch (IOException e) {
//			throw new IOException("Error reading the property file: " + e.getMessage());
//		}
//	}

	public static String getConfigProperty(String filePATH, String key) throws IOException {
		try (FileInputStream fileInputStream = new FileInputStream(filePATH)) {
			Properties properties = new Properties();
			properties.load(fileInputStream);
			return properties.getProperty(key);
		} catch (IOException e) {
			throw new IOException("Error reading the config file: " + e.getMessage());
		}
	}

	public static String captureScreenshot(String scenarioName) {
		if (driver == null)
			return "";
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
		String screenshotPath = "src\\test\\resources\\screenshots\\" + scenarioName + ".png";
//				"test-output/screenshots/" + scenarioName + "_" + timestamp + ".png";
		File destFile = new File(screenshotPath);
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return screenshotPath;
	}

	// Extent Reports
	private static ExtentReports extent;
	public static ExtentTest test;

	public static void setUpReport() {
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/CucumberExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("OS", System.getProperty("os.name"));
	}

	public static void beforeSce(Scenario scenario) {
		String featureFilePath = scenario.getUri().toString();
		String featureFileName = featureFilePath.substring(featureFilePath.lastIndexOf("/")+1);
		//need to continue
		test = extent.createTest(scenario.getName());
	}

	public static void afterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotPath = captureScreenshot(scenario.getName()+scenario.getLine()+scenario.getId());
			test.fail("Scenario Failed: " + scenario.getName());
			if (scenario.isFailed()) {
				test.addScreenCaptureFromPath(screenshotPath);
			} else {
				System.out.println("passed");
			}
		} else {
			test.pass("Scenario Passed: " + scenario.getName());
		}
	}

	public static void flush() {
		extent.flush();
	}

//	// Report genreation
//	private static ExtentReports extent;
//	public static ExtentTest test;
//
//	public static String captureScreenshot(String scenarioName) {
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
//		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
//		String screenshotPath = "test-output/screenshots/" + scenarioName + "_" + timestamp + ".png";
//		File destFile = new File(screenshotPath);
//		try {
//			FileUtils.copyFile(screenshotAs, destFile);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return screenshotPath;
//	}
//
//	public static void setUpReport() {
//		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/CucumberExtentReport.html");
//		extent = new ExtentReports();
//		extent.attachReporter(sparkReporter);
//		extent.setSystemInfo("OS", System.getProperty("os.name"));
//
//	}
//
//	public static void beforeSce(Scenario scenario) {
//		test = extent.createTest(scenario.getName());
//	}
//
//	public static void afterScenario(Scenario scenario) {
//		if (scenario.isFailed()) {
//			test.fail("Scenario Failed" + scenario.getName());
//
//			try {
//				test.addScreenCaptureFromPath(single);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} else {
//			test.pass("Scenario Passed" + scenario.getName());
//		}
//	}
//
//	public static void flush() {
//		extent.flush();
//}

}
