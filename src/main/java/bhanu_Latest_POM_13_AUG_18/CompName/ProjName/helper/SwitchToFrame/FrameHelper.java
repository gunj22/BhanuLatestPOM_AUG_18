package bhanu_Latest_POM_13_AUG_18.CompName.ProjName.helper.SwitchToFrame;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import bhanu_Latest_POM_13_AUG_18.CompName.ProjName.helper.Logger.LoggerHelper;

public class FrameHelper {

	private Logger log = LoggerHelper.getLogger(FrameHelper.class);
	private WebDriver driver;

	/**
	 * Method switchToFrame based on Frame Index
	 * 
	 * @param frameIndex
	 */

	public void switchToFrame(int frameIndex) {
		log.info("Switch to frame " + frameIndex);
		driver.switchTo().frame(frameIndex);

	}

	/**
	 * Method switchToFrame based on Frame Name
	 * 
	 * @param frameName
	 */

	public void swithcToFrame(String frameName) {
		log.info("Switch to frame " + frameName);
		driver.switchTo().frame(frameName);

	}

	/**
	 * Method switchToFrame based on Frame Element
	 * 
	 * @param frameName
	 */

	public void switchToFrame(WebElement element) {
		log.info("Switch to frame " + element.toString());
		driver.switchTo().frame(element);

	}

}
