package bhanu_Latest_POM_13_AUG_18.CompName.ProjName.helper.SwitchToWindow;

import java.util.Set;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import bhanu_Latest_POM_13_AUG_18.CompName.ProjName.helper.Logger.LoggerHelper;

public class SwitchtoWindow {

	private Logger log = LoggerHelper.getLogger(SwitchtoWindow.class);
	private WebDriver driver;

	public SwitchtoWindow(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Method switch to Parent Window
	 */

	public void switchToParentWindow() {
		log.info("Switching to parent window");
		driver.switchTo().defaultContent();
	}

	/**
	 * Method switch to child window based on Index
	 * 
	 * @param index
	 */

	public void switchToWindow(int index) {
		Set<String> windows = driver.getWindowHandles();
		int i = 1;
		for (String window : windows) {
			if (i == index) {
				driver.switchTo().window(window);
			} else {
				i++;
			}
		}

	}

	/**
	 * Method close all child window and switch to main window
	 */

	public void closeAllChildWindowsAndSwitchToMainWindow() {
		Set<String> windows = driver.getWindowHandles();
		String mainWindow = driver.getWindowHandle();

		for (String window : windows) {
			if (!window.equalsIgnoreCase(mainWindow)) {
				log.info("Closing " + window.toString() + " child window");
				driver.close();
			}

		}
		log.info("Switch to " + mainWindow.toString() + " main window");
		driver.switchTo().window(mainWindow);

	}

}
