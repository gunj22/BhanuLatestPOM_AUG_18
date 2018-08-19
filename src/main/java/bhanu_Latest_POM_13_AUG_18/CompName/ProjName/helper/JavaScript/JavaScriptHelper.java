package bhanu_Latest_POM_13_AUG_18.CompName.ProjName.helper.JavaScript;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import bhanu_Latest_POM_13_AUG_18.CompName.ProjName.helper.Logger.LoggerHelper;

public class JavaScriptHelper {

	private Logger log = LoggerHelper.getLogger(JavaScriptHelper.class);
	private WebDriver driver;

	public JavaScriptHelper(WebDriver driver) {
		this.driver = driver;
	}

	public Object executeScript(String script) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript(script);

	}

	public Object executeScript(String script, Object... args) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript(script, args);

	}

	public void scrollToElement(WebElement element) {
		log.info("Scroll to WebElement..");
		executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x, element.getLocation().y);

	}

	public void scrollToElementAndClick(WebElement element) {
		scrollToElement(element);
		element.click();
		log.info("Element is clicked " + element.toString());

	}

	public void scrollInToView(WebElement element) {
		log.info("Scroll till webelement " + element.toString());
		executeScript("arguments[0].scrollIntoView()", element);

	}

	public void scrollInToViewAndClick(WebElement element) {
		scrollInToView(element);
		element.click();
		log.info("Element is clicked: " + element.toString());
	}

	public void scrollDownVertically() {
		log.info("Scrolling Down Vertically");
		executeScript("window.scrollTo(0,document.body.scrollHeight)");

	}

	public void scrollUpVertically() {
		log.info("Scrolling Up Vertically");
		executeScript("window.scrollTo(0,-document.body.scrollHeight)");

	}

	public void scrollDownByPixel(int pixel) {
		executeScript("window.scrollBY(0," + pixel + ")");
	}

	public void scrollUPByPixel(int pixel) {
		executeScript("window.scrollBY(0,-" + pixel + ")");
	}

	public void zoomInBy100Percentage() {
		executeScript("document.body.style.zoom='100%'");
	}

	public void zoomBy60Percentage() {
		executeScript("document.body.style.zoom='60%'");
	}

	public void clickElement(WebElement element) {
		executeScript("arguments[0].click();", element);

	}

}
