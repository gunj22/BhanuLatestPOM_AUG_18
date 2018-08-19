package bhanu_Latest_POM_13_AUG_18.CompName.ProjName.helper.BrowserConfig.config;

import java.io.FileInputStream;
import java.util.Properties;
import bhanu_Latest_POM_13_AUG_18.CompName.ProjName.helper.BrowserConfig.BrowserType;
import bhanu_Latest_POM_13_AUG_18.CompName.ProjName.helper.Resource.ResourceHelper;

public class PropertyReader implements ConfigReader {

	private static FileInputStream fs;
	public static Properties prop;

	public PropertyReader() {
		try {
			fs = new FileInputStream(
					ResourceHelper.getResourcePath("//src//main//resources//configFile//config.properties"));
			prop = new Properties();
			prop.load(fs);

		}

		catch (Exception e) {

			e.printStackTrace();
		}

	}

	public int getImplicitWait() {

		return Integer.parseInt(prop.getProperty("implicitWait"));
	}

	public int getExplicitWait() {

		return Integer.parseInt(prop.getProperty("explicitWait"));
	}

	public int getPageLoadTimeOut() {

		return Integer.parseInt(prop.getProperty("pageLoadTimeOut"));
	}

	public BrowserType getBrowserType() {

		return BrowserType.valueOf(prop.getProperty("browserType"));
	}

}
