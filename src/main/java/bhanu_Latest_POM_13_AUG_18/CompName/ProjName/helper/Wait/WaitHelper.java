package bhanu_Latest_POM_13_AUG_18.CompName.ProjName.helper.Wait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import bhanu_Latest_POM_13_AUG_18.CompName.ProjName.helper.Logger.LoggerHelper;

public class WaitHelper {

	private Logger log = LoggerHelper.getLogger(WaitHelper.class);
	private WebDriver driver;

	public WaitHelper(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * This Method is for ImplicitWait
	 * 
	 * @param timeOut
	 * @param unit
	 */
	public void setImplicitWait(long timeOut, TimeUnit unit) {
		log.info("Implicit Wait is set to : " + timeOut);
		driver.manage().timeouts().implicitlyWait(timeOut, unit);

	}
	
	/**
	 * This Method is for Load page completely
	 * @param timeOut
	 * @param unit
	 */
	

	public void pageLoadTimeOut(long timeOut, TimeUnit unit) {
		log.info("Waiting for " + timeOut + " seconds" + " for page load");
		driver.manage().timeouts().pageLoadTimeout(timeOut, unit);

	}

	/**
	 * This Method is for getting webDriver wait object
	 * 
	 * @param timeOutInSeconds
	 * @param poolingEveryInMiliSec
	 * @return
	 */

	private WebDriverWait getWait(int timeOutInSeconds, int poolingEveryInMiliSec) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.pollingEvery(Duration.ofMillis(poolingEveryInMiliSec));
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		wait.ignoring(TimeoutException.class);
		wait.ignoring(ElementNotSelectableException.class);
		return wait;

	}

	/**
	 * This method is for Element is visible
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 * @param poolingEveryInMiliSec
	 */

	public void waitForElementWithPoolingInterval(WebElement element, int timeOutInSeconds, int poolingEveryInMiliSec) {
		log.info("Waiting for element " + element.toString() + " for : " + timeOutInSeconds + " seconds");
		WebDriverWait wait = getWait(timeOutInSeconds, poolingEveryInMiliSec);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info(element.toString() + "element is visible");
	}

	/**
	 * This method is for Element is clickable
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 * @param poolingEveryInMiliSec
	 */
	public void waitForElementClickable(WebElement element, int timeOutInSeconds, int poolingEveryInMiliSec) {
		log.info(
				"Waiting for element " + element.toString() + " for : " + timeOutInSeconds + " seconds " + " to click");
		WebDriverWait wait = getWait(timeOutInSeconds, poolingEveryInMiliSec);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		log.info(element.toString() + "element is clickable");
	}

	/**
	 * This method is for Frame is available and switched
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 * @param poolingEveryInMiliSec
	 */

	public void waitForFrameToBeAvailableAndSwitch(WebElement element, int timeOutInSeconds,
			int poolingEveryInMiliSec) {

		log.info("Waiting for Frame " + element.toString() + " for : " + timeOutInSeconds + " seconds " + " to switch");
		WebDriverWait wait = getWait(timeOutInSeconds, poolingEveryInMiliSec);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		log.info(element.toString() + " Frame is available and switched");

	}

}
