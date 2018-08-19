package bhanu_Latest_POM_13_AUG_18.CompName.ProjName.helper.BrowserConfig.config;

import bhanu_Latest_POM_13_AUG_18.CompName.ProjName.helper.BrowserConfig.BrowserType;

public interface ConfigReader {

	public int getImplicitWait();

	public int getExplicitWait();

	public int getPageLoadTimeOut();

	public BrowserType getBrowserType();

}
