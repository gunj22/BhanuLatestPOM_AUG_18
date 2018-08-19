package bhanu_Latest_POM_13_AUG_18.CompName.ProjName.helper.BrowserConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import bhanu_Latest_POM_13_AUG_18.CompName.ProjName.helper.Resource.ResourceHelper;

public class FireFoxDriver {

	public FirefoxOptions getFirefoxOptions() {
		DesiredCapabilities firefox = DesiredCapabilities.firefox();

		FirefoxProfile profile = new FirefoxProfile();
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(true);
		firefox.setCapability(FirefoxDriver.PROFILE, profile);
		firefox.setCapability("marionette", true);

		FirefoxOptions fireFoxOptions = new FirefoxOptions(firefox);

		if (System.getProperty("os.name").contains("Linux")) {
			fireFoxOptions.addArguments("--headless", "window-size=1024,768", "--no-sandbox");

		}
		return fireFoxOptions;

	}

	public WebDriver getFireFoxDriver(FirefoxOptions cap) {

		if (System.getProperty("os.name").contains("Window")) {
			System.setProperty("webdriver.gecko.driver",
					ResourceHelper.getResourcePath("//src//main//resources//Drivers//geckodriver.exe"));
			return new FirefoxDriver(cap);
		} else if (System.getProperty("os.name").contains("Mac")) {
			System.setProperty("webdriver.gecko.driver",
					ResourceHelper.getResourcePath("//src//main//resources//Drivers//geckodriver"));
			return new FirefoxDriver(cap);
		} else if (System.getProperty("os.name").contains("Linux")) {
			System.setProperty("webdriver.gecko.driver",
					ResourceHelper.getResourcePath("//src//main//resources//Drivers//geckodriver"));
			return new FirefoxDriver(cap);

		}
		return null;
	}
}