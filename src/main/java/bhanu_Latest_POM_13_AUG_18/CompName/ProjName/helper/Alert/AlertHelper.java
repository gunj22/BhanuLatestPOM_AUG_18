package bhanu_Latest_POM_13_AUG_18.CompName.ProjName.helper.Alert;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import bhanu_Latest_POM_13_AUG_18.CompName.ProjName.helper.Logger.LoggerHelper;

public class AlertHelper {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(AlertHelper.class);

	public AlertHelper(WebDriver driver) {
		this.driver = driver;
		log.info("Alert Helper Object is created");
	}

	public Alert getAlert() {
		return driver.switchTo().alert();
	}

	public void acceptAlert() {
		getAlert().accept();
		log.info("Accept the alert..");
	}

	public void dismissAlert() {
		getAlert().dismiss();
		log.info("Dismiss the alert..");
	}

	public String getAlertText() {
		String text = getAlert().getText();
		log.info("Alert text is : " + text);
		return text;
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			log.info("Alert is present ..");
			return true;
		} catch (NoAlertPresentException e) {
			log.info(e.getCause());
			return false;
		}

	}

	public void acceptAlertIfPresent() {

		if (isAlertPresent()) {
			acceptAlert();
		} else {
			log.info("Alert is not present ..");
		}
	}

	public void dismissAlertIfPresent() {

		if (isAlertPresent()) {
			dismissAlert();
		} else {
			log.info("Alert is not present ..");
		}
	}

	public void acceptAlertWithMessage(String message) {
		if (isAlertPresent()) {
			Alert alert = getAlert();
			alert.sendKeys(message);
			alert.accept();
			log.info("Alert text : " + message);

		}
	}

}
