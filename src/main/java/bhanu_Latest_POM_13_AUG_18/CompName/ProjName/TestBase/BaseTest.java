package bhanu_Latest_POM_13_AUG_18.CompName.ProjName.TestBase;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
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
import bhanu_Latest_POM_13_AUG_18.CompName.ProjName.helper.Logger.LoggerHelper;
import bhanu_Latest_POM_13_AUG_18.CompName.ProjName.helper.Wait.WaitHelper;

public class BaseTest {

	public static ExtentReports extent;
	public static ExtentTest test;
	public WebDriver driver;
	private ConfigReader reader;
	private Logger log = LoggerHelper.getLogger(BaseTest.class);

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

	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getTestName() + " is pass");
		}

		extent.flush();
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
