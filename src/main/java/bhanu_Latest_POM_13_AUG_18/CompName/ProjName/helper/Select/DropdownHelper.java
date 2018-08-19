package bhanu_Latest_POM_13_AUG_18.CompName.ProjName.helper.Select;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import bhanu_Latest_POM_13_AUG_18.CompName.ProjName.helper.Logger.LoggerHelper;

public class DropdownHelper {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(DropdownHelper.class);

	public DropdownHelper(WebDriver driver) {
		this.driver = driver;

	}

	public void selectUsingValue(WebElement element, String value) {
		Select select = new Select(element);
		log.info("SelectUsingValue and value is : " + value);
		select.selectByValue(value);
	}

	public void selectUsingIndex(WebElement element, int index) {
		Select select = new Select(element);
		log.info("SelectUsingIndex and Index is : " + index);
		select.selectByIndex(index);
	}

	public void selectUsingVisibleText(WebElement element, String visibleText) {
		Select select = new Select(element);
		log.info("SelectUsingVisibleText and Text is : " + visibleText);
		select.selectByVisibleText(visibleText);

	}
	
	public List<String> getAllDropdownRecords(WebElement element){
		
		Select select = new Select(element);
		List<WebElement> allRecords = select.getOptions();
		List<String> allRecordsText = new LinkedList<String>();
		for(WebElement ele : allRecords){
			log.info("Text is : " + ele.getText());
			allRecordsText.add(ele.getText());
		}
		return allRecordsText;
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	

}
