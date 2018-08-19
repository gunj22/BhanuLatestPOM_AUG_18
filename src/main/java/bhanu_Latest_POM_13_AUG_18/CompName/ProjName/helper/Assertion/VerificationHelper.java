package bhanu_Latest_POM_13_AUG_18.CompName.ProjName.helper.Assertion;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import bhanu_Latest_POM_13_AUG_18.CompName.ProjName.helper.Logger.LoggerHelper;

public class VerificationHelper {

	private Logger log = LoggerHelper.getLogger(VerificationHelper.class);
	private WebDriver driver;

	public VerificationHelper(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDisplayed(WebElement element) {
		try {

			element.isDisplayed();
			log.info("Element is Displayed .." + element.getText());
			return true;

		} catch (Exception e) {
			log.error("Element is not Displayed ..", e.getCause());
			return false;
		}

	}

	public String getElementText(WebElement element) {

		if (element == null) {
			log.info("Webelement is NULL..");
			return null;
		}
		boolean status = isDisplayed(element);
		if (status == true) {
			return element.getText();
		} else {
			return null;
		}
	}

}
