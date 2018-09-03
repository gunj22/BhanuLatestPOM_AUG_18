package bhanu_Latest_POM_13_AUG_18.CompName.ProjName.TestBase;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import bhanu_Latest_POM_13_AUG_18.CompName.ProjName.Utils.ExtentManager;
import bhanu_Latest_POM_13_AUG_18.CompName.ProjName.helper.BrowserConfig.BrowserType;
import bhanu_Latest_POM_13_AUG_18.CompName.ProjName.helper.BrowserConfig.ChromeBrowser;
import bhanu_Latest_POM_13_AUG_18.CompName.ProjName.helper.BrowserConfig.FireFoxDriver;
import bhanu_Latest_POM_13_AUG_18.CompName.ProjName.helper.BrowserConfig.config.ConfigReader;
import bhanu_Latest_POM_13_AUG_18.CompName.ProjName.helper.BrowserConfig.config.PropertyReader;
import bhanu_Latest_POM_13_AUG_18.CompName.ProjName.helper.JavaScript.JavaScriptHelper;
import bhanu_Latest_POM_13_AUG_18.CompName.ProjName.helper.Logger.LoggerHelper;
import bhanu_Latest_POM_13_AUG_18.CompName.ProjName.helper.Wait.WaitHelper;

public class BaseTest {

	public static ExtentReports extent;
	public static ExtentTest test;
	public WebDriver driver;
	private ConfigReader reader;
	private Logger log = LoggerHelper.getLogger(BaseTest.class);
	public static File reportDirectery;

	@BeforeSuite
	public void beforeSuite() {
		extent = ExtentManager.getInstance();

	}

	@BeforeClass
	public void beforeClass() {
		test = extent.createTest(getClass().getName());

	}

	@BeforeTest
	public void beforeTest() {
		reader = new PropertyReader();
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		test.log(Status.INFO, method.getName() + " test stated..");
		log.info("********************"+method.getName()+"Started*********************");

	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getThrowable());
			String imagePath = captureScreenShot(result.getName(), driver);
			test.addScreenCaptureFromPath(imagePath);
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getTestName() + " is pass");
		}
		log.info("**********************"+result.getName()+"Finshed******************");
		extent.flush();
	}

	@AfterTest
	public void quitBrowser() {
		if (driver != null) {
			driver.quit();
		}

	}

	public String captureScreenShot(String fileName, WebDriver driver) {

		if (driver == null) {
			log.info("driver is null ..");
			return null;
		}
		if (fileName == "") {
			fileName = "blank";

		}

		Reporter.log("Capture Screen Shot Method is Called ..");

		File destFile = null;
		Calendar calender = Calendar.getInstance();

		SimpleDateFormat dateFormater = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {

			destFile = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\screenShots" + "/" + fileName
					+ "_" + dateFormater.format(calender.getTime()) + ".png");
			Files.copy(srcFile.toPath(), destFile.toPath());
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'><img src= '" + destFile.getAbsolutePath()
					+ "'height='100' width='100'/></a>");

		}

		catch (Exception e) {
			e.printStackTrace();

		}
		return destFile.toString();

	}

	public void getNavigationScreenShot(WebDriver driver) {
		log.info("Capturing UI Navigation Screen .. ");
		new JavaScriptHelper(driver).zoomBy60Percentage();
		String screen = captureScreenShot("", driver);
		new JavaScriptHelper(driver).zoomInBy100Percentage();
		try {
			test.addScreenCaptureFromPath(screen);
		} catch (IOException o) {
			o.printStackTrace();
		}
	}

	public void getApplicationUrl(String url) {
		driver.get(url);
		log.info("Navigation to .." + url);
		logExtentReport("Navigation to .." + url);

	}

	public static void logExtentReport(String msg) {
		test.log(Status.INFO, msg);
	}

	public WebDriver getBrowserObject(BrowserType bType) {

		try {
			switch (bType) {
			case Chrome:
				ChromeBrowser chrome = ChromeBrowser.class.newInstance();
				return chrome.getChromeDriver(chrome.getChromeOptions());

			case Firefox:
				FireFoxDriver fireFox = FireFoxDriver.class.newInstance();
				return fireFox.getFireFoxDriver(fireFox.getFirefoxOptions());

			default:
				throw new Exception("Driver not found: " + bType.name());
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return null;

	}

	public void getDriver(BrowserType btype) {

		driver = getBrowserObject(btype);
		log.info("Web Driver is initialize .." + driver.hashCode());
		WaitHelper wait = new WaitHelper(driver);
		wait.setImplicitWait(reader.getImplicitWait(), TimeUnit.SECONDS);
		wait.pageLoadTimeOut(reader.getPageLoadTimeOut(), TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

}
